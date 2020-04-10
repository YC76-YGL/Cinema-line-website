package com.yc.clw.bean;

import java.util.ArrayList;
import java.util.List;

public class ClwTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClwTypeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(Integer value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(Integer value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(Integer value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(Integer value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(Integer value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(Integer value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<Integer> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<Integer> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(Integer value1, Integer value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(Integer value1, Integer value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Integer value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Integer value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Integer value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Integer value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Integer value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Integer> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Integer> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andGenersIsNull() {
            addCriterion("geners is null");
            return (Criteria) this;
        }

        public Criteria andGenersIsNotNull() {
            addCriterion("geners is not null");
            return (Criteria) this;
        }

        public Criteria andGenersEqualTo(Integer value) {
            addCriterion("geners =", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersNotEqualTo(Integer value) {
            addCriterion("geners <>", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersGreaterThan(Integer value) {
            addCriterion("geners >", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersGreaterThanOrEqualTo(Integer value) {
            addCriterion("geners >=", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersLessThan(Integer value) {
            addCriterion("geners <", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersLessThanOrEqualTo(Integer value) {
            addCriterion("geners <=", value, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersIn(List<Integer> values) {
            addCriterion("geners in", values, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersNotIn(List<Integer> values) {
            addCriterion("geners not in", values, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersBetween(Integer value1, Integer value2) {
            addCriterion("geners between", value1, value2, "geners");
            return (Criteria) this;
        }

        public Criteria andGenersNotBetween(Integer value1, Integer value2) {
            addCriterion("geners not between", value1, value2, "geners");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andActorIsNull() {
            addCriterion("actor is null");
            return (Criteria) this;
        }

        public Criteria andActorIsNotNull() {
            addCriterion("actor is not null");
            return (Criteria) this;
        }

        public Criteria andActorEqualTo(Integer value) {
            addCriterion("actor =", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotEqualTo(Integer value) {
            addCriterion("actor <>", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThan(Integer value) {
            addCriterion("actor >", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThanOrEqualTo(Integer value) {
            addCriterion("actor >=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThan(Integer value) {
            addCriterion("actor <", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThanOrEqualTo(Integer value) {
            addCriterion("actor <=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorIn(List<Integer> values) {
            addCriterion("actor in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotIn(List<Integer> values) {
            addCriterion("actor not in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorBetween(Integer value1, Integer value2) {
            addCriterion("actor between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotBetween(Integer value1, Integer value2) {
            addCriterion("actor not between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andGeners1IsNull() {
            addCriterion("geners1 is null");
            return (Criteria) this;
        }

        public Criteria andGeners1IsNotNull() {
            addCriterion("geners1 is not null");
            return (Criteria) this;
        }

        public Criteria andGeners1EqualTo(Integer value) {
            addCriterion("geners1 =", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1NotEqualTo(Integer value) {
            addCriterion("geners1 <>", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1GreaterThan(Integer value) {
            addCriterion("geners1 >", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1GreaterThanOrEqualTo(Integer value) {
            addCriterion("geners1 >=", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1LessThan(Integer value) {
            addCriterion("geners1 <", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1LessThanOrEqualTo(Integer value) {
            addCriterion("geners1 <=", value, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1In(List<Integer> values) {
            addCriterion("geners1 in", values, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1NotIn(List<Integer> values) {
            addCriterion("geners1 not in", values, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1Between(Integer value1, Integer value2) {
            addCriterion("geners1 between", value1, value2, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners1NotBetween(Integer value1, Integer value2) {
            addCriterion("geners1 not between", value1, value2, "geners1");
            return (Criteria) this;
        }

        public Criteria andGeners2IsNull() {
            addCriterion("geners2 is null");
            return (Criteria) this;
        }

        public Criteria andGeners2IsNotNull() {
            addCriterion("geners2 is not null");
            return (Criteria) this;
        }

        public Criteria andGeners2EqualTo(Integer value) {
            addCriterion("geners2 =", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2NotEqualTo(Integer value) {
            addCriterion("geners2 <>", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2GreaterThan(Integer value) {
            addCriterion("geners2 >", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2GreaterThanOrEqualTo(Integer value) {
            addCriterion("geners2 >=", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2LessThan(Integer value) {
            addCriterion("geners2 <", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2LessThanOrEqualTo(Integer value) {
            addCriterion("geners2 <=", value, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2In(List<Integer> values) {
            addCriterion("geners2 in", values, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2NotIn(List<Integer> values) {
            addCriterion("geners2 not in", values, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2Between(Integer value1, Integer value2) {
            addCriterion("geners2 between", value1, value2, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners2NotBetween(Integer value1, Integer value2) {
            addCriterion("geners2 not between", value1, value2, "geners2");
            return (Criteria) this;
        }

        public Criteria andGeners3IsNull() {
            addCriterion("geners3 is null");
            return (Criteria) this;
        }

        public Criteria andGeners3IsNotNull() {
            addCriterion("geners3 is not null");
            return (Criteria) this;
        }

        public Criteria andGeners3EqualTo(Integer value) {
            addCriterion("geners3 =", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3NotEqualTo(Integer value) {
            addCriterion("geners3 <>", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3GreaterThan(Integer value) {
            addCriterion("geners3 >", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3GreaterThanOrEqualTo(Integer value) {
            addCriterion("geners3 >=", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3LessThan(Integer value) {
            addCriterion("geners3 <", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3LessThanOrEqualTo(Integer value) {
            addCriterion("geners3 <=", value, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3In(List<Integer> values) {
            addCriterion("geners3 in", values, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3NotIn(List<Integer> values) {
            addCriterion("geners3 not in", values, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3Between(Integer value1, Integer value2) {
            addCriterion("geners3 between", value1, value2, "geners3");
            return (Criteria) this;
        }

        public Criteria andGeners3NotBetween(Integer value1, Integer value2) {
            addCriterion("geners3 not between", value1, value2, "geners3");
            return (Criteria) this;
        }

        public Criteria andActor2IsNull() {
            addCriterion("actor2 is null");
            return (Criteria) this;
        }

        public Criteria andActor2IsNotNull() {
            addCriterion("actor2 is not null");
            return (Criteria) this;
        }

        public Criteria andActor2EqualTo(Integer value) {
            addCriterion("actor2 =", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotEqualTo(Integer value) {
            addCriterion("actor2 <>", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2GreaterThan(Integer value) {
            addCriterion("actor2 >", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2GreaterThanOrEqualTo(Integer value) {
            addCriterion("actor2 >=", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2LessThan(Integer value) {
            addCriterion("actor2 <", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2LessThanOrEqualTo(Integer value) {
            addCriterion("actor2 <=", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2In(List<Integer> values) {
            addCriterion("actor2 in", values, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotIn(List<Integer> values) {
            addCriterion("actor2 not in", values, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2Between(Integer value1, Integer value2) {
            addCriterion("actor2 between", value1, value2, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotBetween(Integer value1, Integer value2) {
            addCriterion("actor2 not between", value1, value2, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor3IsNull() {
            addCriterion("actor3 is null");
            return (Criteria) this;
        }

        public Criteria andActor3IsNotNull() {
            addCriterion("actor3 is not null");
            return (Criteria) this;
        }

        public Criteria andActor3EqualTo(Integer value) {
            addCriterion("actor3 =", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotEqualTo(Integer value) {
            addCriterion("actor3 <>", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3GreaterThan(Integer value) {
            addCriterion("actor3 >", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3GreaterThanOrEqualTo(Integer value) {
            addCriterion("actor3 >=", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3LessThan(Integer value) {
            addCriterion("actor3 <", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3LessThanOrEqualTo(Integer value) {
            addCriterion("actor3 <=", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3In(List<Integer> values) {
            addCriterion("actor3 in", values, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotIn(List<Integer> values) {
            addCriterion("actor3 not in", values, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3Between(Integer value1, Integer value2) {
            addCriterion("actor3 between", value1, value2, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotBetween(Integer value1, Integer value2) {
            addCriterion("actor3 not between", value1, value2, "actor3");
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