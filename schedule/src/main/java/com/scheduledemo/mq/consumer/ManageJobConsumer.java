package com.scheduledemo.mq.consumer;

import com.scheduledemo.model.Job;
import com.scheduledemo.model.JobExample;
import com.scheduledemo.model.JobStatus;
import com.scheduledemo.model.PlatformEnum;
import com.scheduledemo.mq.producer.ExecuteJobProducer;
import com.scheduledemo.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by tanjianhui on 2017/3/8.
 */
@Component("manageJobConsumer")
public class ManageJobConsumer implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(ManageJobConsumer.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private ExecuteJobProducer executeJobProducer;

    public void handle(String message){
        Date now = new Date();

        // 处理超时作业
        jobService.processTimeoutJob();

        // 获取状态为New、Intial、Processing或Timeout，下次执行时间小于或等于当前时间的作业(待分组计算)
        JobExample jobExample = new JobExample();
        List<String> statusList = Arrays.asList(
                        JobStatus.NEW.getKey(), JobStatus.INITIAL.getKey(),
                        JobStatus.PROCESSING.getKey()/*, JobStatus.TIMEOUT.getKey()*/);
        jobExample.createCriteria().andStatusIn(statusList).andNextRunTimeLessThan(new Date());
        List<Job> jobListDividingIntoGroup = jobService.selectByExample(jobExample);

        // 按开发者账号分组可运行作业
        Map<Integer, RunnableJobGroup> runnableJobGroups = new HashMap();
        for (Job job : jobListDividingIntoGroup){
            Integer deaId = job.getDeaId();
            Integer platformId = job.getPlaId();
            String jobStatus = job.getStatus();

            RunnableJobGroup runnableJobGroup = runnableJobGroups.get(deaId);
            if(null == runnableJobGroup){
                int maxRunnableJobCount;
                if(PlatformEnum.AMAZON.isPlatform(platformId)){
                    maxRunnableJobCount = Integer.MAX_VALUE;
                }else if(platformId.equals(PlatformEnum.EBAY.getKey())){
                    maxRunnableJobCount = 18;
                }else{
                    logger.warn("作业关联未知的平台类型，跳过。jobId : {}, platformId : {}", job.getJobId(), platformId);
                    continue;
                }

                runnableJobGroups.put(deaId, (runnableJobGroup = new RunnableJobGroup(deaId, platformId, maxRunnableJobCount)));
            }

            if(JobStatus.NEW.getKey().equals(jobStatus)){
                runnableJobGroup.addRunnableJob(job);
            }else{
                runnableJobGroup.increaseRunningJobCount(1);
            }
        }

        // 遍历待运行作业（状态为New）分组
        for(RunnableJobGroup runnableJobGroup : runnableJobGroups.values()){
            List<Job> jobList = runnableJobGroup.getRunnableJobList();
            for(Job job : jobList){
                // 修改作业状态为Initial
                Job updateStatusJob = new Job();
                updateStatusJob.setJobId(job.getJobId());
                updateStatusJob.setStatus(JobStatus.INITIAL.getKey());
                updateStatusJob.setLastUpdateBy("admin");
                updateStatusJob.setLastUpdateTime(new Date());
                jobService.updateByPrimaryKeySelectiveRN(updateStatusJob);

                // 发送消息
                executeJobProducer.execute(job);
            }

        }
    }

    private static class RunnableJobGroup{
        // 开发发者账号主键
        private Integer deaId;
        // 平台主键
        private Integer platformId;
        // 运行中的作业数（状态为Initial、Processing）
        private Integer runningJobCount;
        // 可运行作业最大数量
        private Integer maxRunnableJobCount;
        // 可运行作业列表
        private List<Job> runnableJobList;

        public Integer getPlatformId(){
            return this.getPlatformId();
        }

        public RunnableJobGroup(Integer deaId, Integer platformId, Integer maxRunnableJobCount){
            this.deaId = deaId;
            this.platformId = platformId;
            this.runningJobCount = 0;
            this.maxRunnableJobCount = maxRunnableJobCount;
            runnableJobList = new ArrayList<>();
        }

        public void increaseRunningJobCount(Integer count){
            runningJobCount += count;
        }

        public void addRunnableJob(Job job){
            for (Job j : runnableJobList) {
                if (j.getPriority().compareTo(job.getPriority()) < 0){
                    runnableJobList.add(runnableJobList.indexOf(j),job);
                    return ;
                }
            }
            runnableJobList.add(job);
        }

        public List<Job> getRunnableJobList(){
            int runnableJobCount = maxRunnableJobCount - runningJobCount;
            if(runnableJobCount > 0){
                return runnableJobList.subList(0,
                        runnableJobCount < runnableJobList.size() ? runnableJobCount : runnableJobList.size());
            }
            return new ArrayList<>();
        }
    }

    @Override
    public void onMessage(Message message) {
        this.handle(new String(message.getBody()));
    }
}
