package com.scheduledemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTasIdIsNull() {
            addCriterion("tas_id is null");
            return (Criteria) this;
        }

        public Criteria andTasIdIsNotNull() {
            addCriterion("tas_id is not null");
            return (Criteria) this;
        }

        public Criteria andTasIdEqualTo(Integer value) {
            addCriterion("tas_id =", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotEqualTo(Integer value) {
            addCriterion("tas_id <>", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdGreaterThan(Integer value) {
            addCriterion("tas_id >", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tas_id >=", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdLessThan(Integer value) {
            addCriterion("tas_id <", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdLessThanOrEqualTo(Integer value) {
            addCriterion("tas_id <=", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdIn(List<Integer> values) {
            addCriterion("tas_id in", values, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotIn(List<Integer> values) {
            addCriterion("tas_id not in", values, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdBetween(Integer value1, Integer value2) {
            addCriterion("tas_id between", value1, value2, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tas_id not between", value1, value2, "tasId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeIsNull() {
            addCriterion("estimate_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeIsNotNull() {
            addCriterion("estimate_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeEqualTo(Integer value) {
            addCriterion("estimate_cost_time =", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeNotEqualTo(Integer value) {
            addCriterion("estimate_cost_time <>", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeGreaterThan(Integer value) {
            addCriterion("estimate_cost_time >", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimate_cost_time >=", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeLessThan(Integer value) {
            addCriterion("estimate_cost_time <", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeLessThanOrEqualTo(Integer value) {
            addCriterion("estimate_cost_time <=", value, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeIn(List<Integer> values) {
            addCriterion("estimate_cost_time in", values, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeNotIn(List<Integer> values) {
            addCriterion("estimate_cost_time not in", values, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeBetween(Integer value1, Integer value2) {
            addCriterion("estimate_cost_time between", value1, value2, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCostTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("estimate_cost_time not between", value1, value2, "estimateCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeIsNull() {
            addCriterion("estimate_max_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeIsNotNull() {
            addCriterion("estimate_max_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeEqualTo(Integer value) {
            addCriterion("estimate_max_cost_time =", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeNotEqualTo(Integer value) {
            addCriterion("estimate_max_cost_time <>", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeGreaterThan(Integer value) {
            addCriterion("estimate_max_cost_time >", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimate_max_cost_time >=", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeLessThan(Integer value) {
            addCriterion("estimate_max_cost_time <", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeLessThanOrEqualTo(Integer value) {
            addCriterion("estimate_max_cost_time <=", value, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeIn(List<Integer> values) {
            addCriterion("estimate_max_cost_time in", values, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeNotIn(List<Integer> values) {
            addCriterion("estimate_max_cost_time not in", values, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeBetween(Integer value1, Integer value2) {
            addCriterion("estimate_max_cost_time between", value1, value2, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andEstimateMaxCostTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("estimate_max_cost_time not between", value1, value2, "estimateMaxCostTime");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andConcurrencyIsNull() {
            addCriterion("concurrency is null");
            return (Criteria) this;
        }

        public Criteria andConcurrencyIsNotNull() {
            addCriterion("concurrency is not null");
            return (Criteria) this;
        }

        public Criteria andConcurrencyEqualTo(String value) {
            addCriterion("concurrency =", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyNotEqualTo(String value) {
            addCriterion("concurrency <>", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyGreaterThan(String value) {
            addCriterion("concurrency >", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("concurrency >=", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyLessThan(String value) {
            addCriterion("concurrency <", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyLessThanOrEqualTo(String value) {
            addCriterion("concurrency <=", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyLike(String value) {
            addCriterion("concurrency like", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyNotLike(String value) {
            addCriterion("concurrency not like", value, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyIn(List<String> values) {
            addCriterion("concurrency in", values, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyNotIn(List<String> values) {
            addCriterion("concurrency not in", values, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyBetween(String value1, String value2) {
            addCriterion("concurrency between", value1, value2, "concurrency");
            return (Criteria) this;
        }

        public Criteria andConcurrencyNotBetween(String value1, String value2) {
            addCriterion("concurrency not between", value1, value2, "concurrency");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNull() {
            addCriterion("retry_rule is null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNotNull() {
            addCriterion("retry_rule is not null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleEqualTo(String value) {
            addCriterion("retry_rule =", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotEqualTo(String value) {
            addCriterion("retry_rule <>", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThan(String value) {
            addCriterion("retry_rule >", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThanOrEqualTo(String value) {
            addCriterion("retry_rule >=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThan(String value) {
            addCriterion("retry_rule <", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThanOrEqualTo(String value) {
            addCriterion("retry_rule <=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLike(String value) {
            addCriterion("retry_rule like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotLike(String value) {
            addCriterion("retry_rule not like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIn(List<String> values) {
            addCriterion("retry_rule in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotIn(List<String> values) {
            addCriterion("retry_rule not in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleBetween(String value1, String value2) {
            addCriterion("retry_rule between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotBetween(String value1, String value2) {
            addCriterion("retry_rule not between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNull() {
            addCriterion("last_update_by is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNotNull() {
            addCriterion("last_update_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByEqualTo(String value) {
            addCriterion("last_update_by =", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotEqualTo(String value) {
            addCriterion("last_update_by <>", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThan(String value) {
            addCriterion("last_update_by >", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_by >=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThan(String value) {
            addCriterion("last_update_by <", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThanOrEqualTo(String value) {
            addCriterion("last_update_by <=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLike(String value) {
            addCriterion("last_update_by like", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotLike(String value) {
            addCriterion("last_update_by not like", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIn(List<String> values) {
            addCriterion("last_update_by in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotIn(List<String> values) {
            addCriterion("last_update_by not in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByBetween(String value1, String value2) {
            addCriterion("last_update_by between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotBetween(String value1, String value2) {
            addCriterion("last_update_by not between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}