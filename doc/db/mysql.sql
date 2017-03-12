drop table if exists dea_developer_account;
drop table if exists sda_store_developer_account;
drop table if exists tas_task;
drop table if exists sch_scheduler;
drop table if exists scl_scheduler_log;
drop table if exists job_job;
drop table if exists joe_job_error;

create table dea_developer_account
(
  dea_id int not null auto_increment comment '主键',
  platform_id int not null comment '平台主键 1-Amazon 2-eBay',
  account_info varchar(2000) not null comment '开发者账号信息（格式：JSON）',
  concurrency int not null default 0 comment '并发数限制 0-无限制',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key(dea_id)
) engine=innodb comment '开发者账号';

create table sda_store_developer_account
(
  sda_id int not null auto_increment comment '主键',
  str_id int not null comment '店铺主键',
  dea_id int not null comment '开发者账号主键',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key(sda_id),
  unique(str_id)
) engine=innodb comment '店铺开发者账号';

create table tas_task
(
  tas_id int not null auto_increment comment '主键',
  name varchar(50) not null comment '任务名称',
  estimate_cost_time int not null comment '预计花费时间（单位：分钟）',
  estimate_max_cost_time int not null comment '预计最大花费时间（单位：分钟）',
  priority int not null comment '优先级 取值范围1-10，1最低，10最高，默认为5。',
  concurrency varchar(1) not null comment '能否并发执行 0-否 1-是',
  retry_rule varchar(2000) not null comment '重试规则（格式：JSON）',
  remark varchar(100) comment '备注',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key(tas_id)
) engine=innodb comment '任务';

create table sch_scheduler
(
  sch_id int not null auto_increment comment '主键',
  tas_id int not null comment '任务主键',
  operation varchar(1) not null comment '操作类型 1-新增 2-暂停 3-恢复',
  name varchar(50) not null comment '名称',
  cron_expression varchar(100) not null comment 'cron表达式',
  status varchar(1) not null comment '状态 0-未生效 1-已生效',
  remark varchar(100) comment '备注',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key (sch_id)
) engine=innodb comment '调度器';

create table scl_scheduler_log
(
  scl_id int not null auto_increment comment '主键',
  sch_id int not null comment '调度器主键',
  status varchar(1) not null comment '状态 1-执行中 2-成功 3-失败',
  error_message varchar(2000) comment '错误信息',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key (scl_id)
) engine=innodb comment '调度器执行日志';

create table job_job
(
  job_id int not null auto_increment comment '主键',
  tas_id int not null comment '任务主键',
  str_id int not null comment '店铺主键',
  dea_id int not null comment '开发者账号主键',
  pla_id int not null comment '平台主键',
  business_parameter varchar(2000) comment '业务参数 格式：JSON',
  start_time timestamp not null comment '开始时间',
  complete_time timestamp comment '完成时间',
  estimate_complete_time timestamp not null comment '预计完成时间',
  estimate_longest_complete_time timestamp not null comment '最大预计完成时间',
  priority int not null comment '优先级 取值范围1-10，1最低，10最高，默认为5。',
  fail_counter int not null comment '失败次数',
  next_run_time timestamp not null comment '下次执行时间 默认为创建时间',
  status varchar(1) not null comment '状态 1-New 2-Initial 3-Processing 4-Timeout 5-Done 6-Fail 7-Killed',
  remark varchar(2000) comment '备注',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key (job_id)
) engine=innodb comment '作业';

create table joe_job_error
(
  joe_id int not null auto_increment comment '主键',
  job_id int not null comment '作业监控主键',
  error_message varchar(2000) comment '错误信息',

  create_by varchar(20) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time timestamp comment '最后修改时间',

  primary key(joe_id)
) engine=innodb comment '作业错误';



DELETE FROM tas_task;

INSERT INTO tas_task
(name, estimate_cost_time, estimate_max_cost_time, priority, concurrency, retry_rule, remark, create_by, create_time)
VALUES ('库存同步', 5, 10, 5, '0',
        '[{"failCountFloor":1,"failCountUpper":3,"retryInterval":1},{"failCountFloor":4,"failCountUpper":6,"retryInterval":5},{"failCountFloor":7,"failCountUpper":9,"retryInterval":10}]',
        '', 'admin', current_timestamp);

DELETE FROM sch_scheduler;

INSERT INTO sch_scheduler
(tas_id, operation, name, cron_expression, status, remark, create_by, create_time)
VALUES (1, '1', 'stockSync', '0 0/15 * * * ?', '0', '', 'admin', current_timestamp);
