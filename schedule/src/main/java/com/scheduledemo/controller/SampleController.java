package com.scheduledemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.scheduledemo.mq.producer.ExecuteJobProducer;
import com.scheduledemo.schedule.AmazonScheduler;
import com.scheduledemo.schedule.JobManagingScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JobManagingScheduler jobManagingScheduler;

    @Autowired
    private AmazonScheduler amazonScheduler;

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        return "Hello World!";
    }

    @RequestMapping("/sendNewJobMessage")
    @ResponseBody
    public String sendNewJobMessage(){


        Map<String, Object> header = new HashMap<>();
        header.put("sendType", "2");
        header.put("receiver", "system");
        header.put("sender", "system");
        header.put("sendDate", System.currentTimeMillis());

        Map<String, Object> refreshInventory = new HashMap<>();
        refreshInventory.put("prodId", null);
        refreshInventory.put("strId", null);
        refreshInventory.put("qty", null);

        Map<String, Object> message = new HashMap<>();
        message.put("header", header);
        message.put("refreshInventory", refreshInventory);

        String jsonString = JSON.toJSONString(message, SerializerFeature.WriteMapNullValue);
        logger.info("jsonString : {}", jsonString);
        rabbitTemplate.convertAndSend("INVENTORY_API_QUEUE_KEY", jsonString.getBytes());

        return "Test Message!";
    }

    @RequestMapping("/checkContextPath")
    @ResponseBody
    public String checkContextPath(HttpServletRequest request){
        return "<script>alert(1);parent.location.href='"
                + request.getContextPath() + "/sayHello';</script>";
    }

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello, how do you do!";
    }

    @RequestMapping("/getHost")
//    @ResponseBody
    public void getHost(HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("Scheme: {}", request.getScheme());
        logger.info("RequestURI: {}", request.getRequestURI());
        logger.info("RequestURL: {}", request.getRequestURL());
        logger.info("ServerName: {}", request.getServerName());
        logger.info("ServerPort: {}", request.getServerPort());
        logger.info("ContextPath: {}", request.getContextPath());
        logger.info("QueryString: {}", request.getQueryString());

        response.sendRedirect(request.getContextPath() + "/sayHello");
    }

    @RequestMapping("/execJob")
    @ResponseBody
    public String execJob(){
        jobManagingScheduler.execute();

        return "Execute Job!";
    }

    @RequestMapping("/amazonScheduler")
    @ResponseBody
    public String amazonScheduler(){
        amazonScheduler.check();
        amazonScheduler.recoverExecution();
        amazonScheduler.recoverExecutionTimeBy();
        amazonScheduler.submitFulfillment();
        amazonScheduler.submitInventory();
        amazonScheduler.submitProduct();
        amazonScheduler.submitProductImage();
        amazonScheduler.submitProductRelationship();

        return "amazonScheduler!";
    }
}