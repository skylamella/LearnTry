package cn.skyln.pojo;

import java.util.ArrayList;
import java.util.List;

public class MailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailExample() {
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

        public Criteria andMailIdIsNull() {
            addCriterion("mail_id is null");
            return (Criteria) this;
        }

        public Criteria andMailIdIsNotNull() {
            addCriterion("mail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailIdEqualTo(Integer value) {
            addCriterion("mail_id =", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotEqualTo(Integer value) {
            addCriterion("mail_id <>", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThan(Integer value) {
            addCriterion("mail_id >", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_id >=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThan(Integer value) {
            addCriterion("mail_id <", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThanOrEqualTo(Integer value) {
            addCriterion("mail_id <=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdIn(List<Integer> values) {
            addCriterion("mail_id in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotIn(List<Integer> values) {
            addCriterion("mail_id not in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdBetween(Integer value1, Integer value2) {
            addCriterion("mail_id between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_id not between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNull() {
            addCriterion("mail_title is null");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNotNull() {
            addCriterion("mail_title is not null");
            return (Criteria) this;
        }

        public Criteria andMailTitleEqualTo(String value) {
            addCriterion("mail_title =", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotEqualTo(String value) {
            addCriterion("mail_title <>", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThan(String value) {
            addCriterion("mail_title >", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mail_title >=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThan(String value) {
            addCriterion("mail_title <", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThanOrEqualTo(String value) {
            addCriterion("mail_title <=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLike(String value) {
            addCriterion("mail_title like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotLike(String value) {
            addCriterion("mail_title not like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleIn(List<String> values) {
            addCriterion("mail_title in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotIn(List<String> values) {
            addCriterion("mail_title not in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleBetween(String value1, String value2) {
            addCriterion("mail_title between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotBetween(String value1, String value2) {
            addCriterion("mail_title not between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailChkIsNull() {
            addCriterion("mail_chk is null");
            return (Criteria) this;
        }

        public Criteria andMailChkIsNotNull() {
            addCriterion("mail_chk is not null");
            return (Criteria) this;
        }

        public Criteria andMailChkEqualTo(String value) {
            addCriterion("mail_chk =", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkNotEqualTo(String value) {
            addCriterion("mail_chk <>", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkGreaterThan(String value) {
            addCriterion("mail_chk >", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkGreaterThanOrEqualTo(String value) {
            addCriterion("mail_chk >=", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkLessThan(String value) {
            addCriterion("mail_chk <", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkLessThanOrEqualTo(String value) {
            addCriterion("mail_chk <=", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkLike(String value) {
            addCriterion("mail_chk like", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkNotLike(String value) {
            addCriterion("mail_chk not like", value, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkIn(List<String> values) {
            addCriterion("mail_chk in", values, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkNotIn(List<String> values) {
            addCriterion("mail_chk not in", values, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkBetween(String value1, String value2) {
            addCriterion("mail_chk between", value1, value2, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailChkNotBetween(String value1, String value2) {
            addCriterion("mail_chk not between", value1, value2, "mailChk");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserIsNull() {
            addCriterion("mail_createUser is null");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserIsNotNull() {
            addCriterion("mail_createUser is not null");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserEqualTo(Integer value) {
            addCriterion("mail_createUser =", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserNotEqualTo(Integer value) {
            addCriterion("mail_createUser <>", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserGreaterThan(Integer value) {
            addCriterion("mail_createUser >", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_createUser >=", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserLessThan(Integer value) {
            addCriterion("mail_createUser <", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserLessThanOrEqualTo(Integer value) {
            addCriterion("mail_createUser <=", value, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserIn(List<Integer> values) {
            addCriterion("mail_createUser in", values, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserNotIn(List<Integer> values) {
            addCriterion("mail_createUser not in", values, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserBetween(Integer value1, Integer value2) {
            addCriterion("mail_createUser between", value1, value2, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailCreateuserNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_createUser not between", value1, value2, "mailCreateuser");
            return (Criteria) this;
        }

        public Criteria andMailTouserIsNull() {
            addCriterion("mail_toUser is null");
            return (Criteria) this;
        }

        public Criteria andMailTouserIsNotNull() {
            addCriterion("mail_toUser is not null");
            return (Criteria) this;
        }

        public Criteria andMailTouserEqualTo(Integer value) {
            addCriterion("mail_toUser =", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserNotEqualTo(Integer value) {
            addCriterion("mail_toUser <>", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserGreaterThan(Integer value) {
            addCriterion("mail_toUser >", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_toUser >=", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserLessThan(Integer value) {
            addCriterion("mail_toUser <", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserLessThanOrEqualTo(Integer value) {
            addCriterion("mail_toUser <=", value, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserIn(List<Integer> values) {
            addCriterion("mail_toUser in", values, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserNotIn(List<Integer> values) {
            addCriterion("mail_toUser not in", values, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserBetween(Integer value1, Integer value2) {
            addCriterion("mail_toUser between", value1, value2, "mailTouser");
            return (Criteria) this;
        }

        public Criteria andMailTouserNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_toUser not between", value1, value2, "mailTouser");
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