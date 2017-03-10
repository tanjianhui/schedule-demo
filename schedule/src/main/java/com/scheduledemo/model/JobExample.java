package com.scheduledemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
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

        public Criteria andStrIdIsNull() {
            addCriterion("str_id is null");
            return (Criteria) this;
        }

        public Criteria andStrIdIsNotNull() {
            addCriterion("str_id is not null");
            return (Criteria) this;
        }

        public Criteria andStrIdEqualTo(Integer value) {
            addCriterion("str_id =", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotEqualTo(Integer value) {
            addCriterion("str_id <>", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdGreaterThan(Integer value) {
            addCriterion("str_id >", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("str_id >=", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdLessThan(Integer value) {
            addCriterion("str_id <", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdLessThanOrEqualTo(Integer value) {
            addCriterion("str_id <=", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdIn(List<Integer> values) {
            addCriterion("str_id in", values, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotIn(List<Integer> values) {
            addCriterion("str_id not in", values, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdBetween(Integer value1, Integer value2) {
            addCriterion("str_id between", value1, value2, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("str_id not between", value1, value2, "strId");
            return (Criteria) this;
        }

        public Criteria andDeaIdIsNull() {
            addCriterion("dea_id is null");
            return (Criteria) this;
        }

        public Criteria andDeaIdIsNotNull() {
            addCriterion("dea_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeaIdEqualTo(Integer value) {
            addCriterion("dea_id =", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdNotEqualTo(Integer value) {
            addCriterion("dea_id <>", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdGreaterThan(Integer value) {
            addCriterion("dea_id >", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dea_id >=", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdLessThan(Integer value) {
            addCriterion("dea_id <", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdLessThanOrEqualTo(Integer value) {
            addCriterion("dea_id <=", value, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdIn(List<Integer> values) {
            addCriterion("dea_id in", values, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdNotIn(List<Integer> values) {
            addCriterion("dea_id not in", values, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdBetween(Integer value1, Integer value2) {
            addCriterion("dea_id between", value1, value2, "deaId");
            return (Criteria) this;
        }

        public Criteria andDeaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dea_id not between", value1, value2, "deaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdIsNull() {
            addCriterion("pla_id is null");
            return (Criteria) this;
        }

        public Criteria andPlaIdIsNotNull() {
            addCriterion("pla_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlaIdEqualTo(Integer value) {
            addCriterion("pla_id =", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdNotEqualTo(Integer value) {
            addCriterion("pla_id <>", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdGreaterThan(Integer value) {
            addCriterion("pla_id >", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pla_id >=", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdLessThan(Integer value) {
            addCriterion("pla_id <", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdLessThanOrEqualTo(Integer value) {
            addCriterion("pla_id <=", value, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdIn(List<Integer> values) {
            addCriterion("pla_id in", values, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdNotIn(List<Integer> values) {
            addCriterion("pla_id not in", values, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdBetween(Integer value1, Integer value2) {
            addCriterion("pla_id between", value1, value2, "plaId");
            return (Criteria) this;
        }

        public Criteria andPlaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pla_id not between", value1, value2, "plaId");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterIsNull() {
            addCriterion("business_parameter is null");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterIsNotNull() {
            addCriterion("business_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterEqualTo(String value) {
            addCriterion("business_parameter =", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterNotEqualTo(String value) {
            addCriterion("business_parameter <>", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterGreaterThan(String value) {
            addCriterion("business_parameter >", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterGreaterThanOrEqualTo(String value) {
            addCriterion("business_parameter >=", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterLessThan(String value) {
            addCriterion("business_parameter <", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterLessThanOrEqualTo(String value) {
            addCriterion("business_parameter <=", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterLike(String value) {
            addCriterion("business_parameter like", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterNotLike(String value) {
            addCriterion("business_parameter not like", value, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterIn(List<String> values) {
            addCriterion("business_parameter in", values, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterNotIn(List<String> values) {
            addCriterion("business_parameter not in", values, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterBetween(String value1, String value2) {
            addCriterion("business_parameter between", value1, value2, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andBusinessParameterNotBetween(String value1, String value2) {
            addCriterion("business_parameter not between", value1, value2, "businessParameter");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeIsNull() {
            addCriterion("estimate_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeIsNotNull() {
            addCriterion("estimate_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeEqualTo(Date value) {
            addCriterion("estimate_complete_time =", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeNotEqualTo(Date value) {
            addCriterion("estimate_complete_time <>", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeGreaterThan(Date value) {
            addCriterion("estimate_complete_time >", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("estimate_complete_time >=", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeLessThan(Date value) {
            addCriterion("estimate_complete_time <", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("estimate_complete_time <=", value, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeIn(List<Date> values) {
            addCriterion("estimate_complete_time in", values, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeNotIn(List<Date> values) {
            addCriterion("estimate_complete_time not in", values, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("estimate_complete_time between", value1, value2, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("estimate_complete_time not between", value1, value2, "estimateCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeIsNull() {
            addCriterion("estimate_longest_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeIsNotNull() {
            addCriterion("estimate_longest_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeEqualTo(Date value) {
            addCriterion("estimate_longest_complete_time =", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeNotEqualTo(Date value) {
            addCriterion("estimate_longest_complete_time <>", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeGreaterThan(Date value) {
            addCriterion("estimate_longest_complete_time >", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("estimate_longest_complete_time >=", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeLessThan(Date value) {
            addCriterion("estimate_longest_complete_time <", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("estimate_longest_complete_time <=", value, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeIn(List<Date> values) {
            addCriterion("estimate_longest_complete_time in", values, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeNotIn(List<Date> values) {
            addCriterion("estimate_longest_complete_time not in", values, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("estimate_longest_complete_time between", value1, value2, "estimateLongestCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEstimateLongestCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("estimate_longest_complete_time not between", value1, value2, "estimateLongestCompleteTime");
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

        public Criteria andFailCounterIsNull() {
            addCriterion("fail_counter is null");
            return (Criteria) this;
        }

        public Criteria andFailCounterIsNotNull() {
            addCriterion("fail_counter is not null");
            return (Criteria) this;
        }

        public Criteria andFailCounterEqualTo(Integer value) {
            addCriterion("fail_counter =", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterNotEqualTo(Integer value) {
            addCriterion("fail_counter <>", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterGreaterThan(Integer value) {
            addCriterion("fail_counter >", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail_counter >=", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterLessThan(Integer value) {
            addCriterion("fail_counter <", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterLessThanOrEqualTo(Integer value) {
            addCriterion("fail_counter <=", value, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterIn(List<Integer> values) {
            addCriterion("fail_counter in", values, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterNotIn(List<Integer> values) {
            addCriterion("fail_counter not in", values, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterBetween(Integer value1, Integer value2) {
            addCriterion("fail_counter between", value1, value2, "failCounter");
            return (Criteria) this;
        }

        public Criteria andFailCounterNotBetween(Integer value1, Integer value2) {
            addCriterion("fail_counter not between", value1, value2, "failCounter");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeIsNull() {
            addCriterion("next_run_time is null");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeIsNotNull() {
            addCriterion("next_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeEqualTo(Date value) {
            addCriterion("next_run_time =", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeNotEqualTo(Date value) {
            addCriterion("next_run_time <>", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeGreaterThan(Date value) {
            addCriterion("next_run_time >", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_run_time >=", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeLessThan(Date value) {
            addCriterion("next_run_time <", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_run_time <=", value, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeIn(List<Date> values) {
            addCriterion("next_run_time in", values, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeNotIn(List<Date> values) {
            addCriterion("next_run_time not in", values, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeBetween(Date value1, Date value2) {
            addCriterion("next_run_time between", value1, value2, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andNextRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_run_time not between", value1, value2, "nextRunTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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