package cn.skyln.news.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private Integer currentPage;

	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public NewsExample() {
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

		public Criteria andNewsIdIsNull() {
			addCriterion("news_id is null");
			return (Criteria) this;
		}

		public Criteria andNewsIdIsNotNull() {
			addCriterion("news_id is not null");
			return (Criteria) this;
		}

		public Criteria andNewsIdEqualTo(Integer value) {
			addCriterion("news_id =", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdNotEqualTo(Integer value) {
			addCriterion("news_id <>", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdGreaterThan(Integer value) {
			addCriterion("news_id >", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("news_id >=", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdLessThan(Integer value) {
			addCriterion("news_id <", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdLessThanOrEqualTo(Integer value) {
			addCriterion("news_id <=", value, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdIn(List<Integer> values) {
			addCriterion("news_id in", values, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdNotIn(List<Integer> values) {
			addCriterion("news_id not in", values, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdBetween(Integer value1, Integer value2) {
			addCriterion("news_id between", value1, value2, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsIdNotBetween(Integer value1, Integer value2) {
			addCriterion("news_id not between", value1, value2, "newsId");
			return (Criteria) this;
		}

		public Criteria andNewsCreateIsNull() {
			addCriterion("news_create is null");
			return (Criteria) this;
		}

		public Criteria andNewsCreateIsNotNull() {
			addCriterion("news_create is not null");
			return (Criteria) this;
		}

		public Criteria andNewsCreateEqualTo(Date value) {
			addCriterion("news_create =", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateNotEqualTo(Date value) {
			addCriterion("news_create <>", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateGreaterThan(Date value) {
			addCriterion("news_create >", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateGreaterThanOrEqualTo(Date value) {
			addCriterion("news_create >=", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateLessThan(Date value) {
			addCriterion("news_create <", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateLessThanOrEqualTo(Date value) {
			addCriterion("news_create <=", value, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateIn(List<Date> values) {
			addCriterion("news_create in", values, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateNotIn(List<Date> values) {
			addCriterion("news_create not in", values, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateBetween(Date value1, Date value2) {
			addCriterion("news_create between", value1, value2, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsCreateNotBetween(Date value1, Date value2) {
			addCriterion("news_create not between", value1, value2, "newsCreate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateIsNull() {
			addCriterion("news_update is null");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateIsNotNull() {
			addCriterion("news_update is not null");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateEqualTo(Date value) {
			addCriterion("news_update =", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateNotEqualTo(Date value) {
			addCriterion("news_update <>", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateGreaterThan(Date value) {
			addCriterion("news_update >", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateGreaterThanOrEqualTo(Date value) {
			addCriterion("news_update >=", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateLessThan(Date value) {
			addCriterion("news_update <", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateLessThanOrEqualTo(Date value) {
			addCriterion("news_update <=", value, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateIn(List<Date> values) {
			addCriterion("news_update in", values, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateNotIn(List<Date> values) {
			addCriterion("news_update not in", values, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateBetween(Date value1, Date value2) {
			addCriterion("news_update between", value1, value2, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andNewsUpdateNotBetween(Date value1, Date value2) {
			addCriterion("news_update not between", value1, value2, "newsUpdate");
			return (Criteria) this;
		}

		public Criteria andUserIdCreIsNull() {
			addCriterion("user_id_cre is null");
			return (Criteria) this;
		}

		public Criteria andUserIdCreIsNotNull() {
			addCriterion("user_id_cre is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdCreEqualTo(Integer value) {
			addCriterion("user_id_cre =", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreNotEqualTo(Integer value) {
			addCriterion("user_id_cre <>", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreGreaterThan(Integer value) {
			addCriterion("user_id_cre >", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id_cre >=", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreLessThan(Integer value) {
			addCriterion("user_id_cre <", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreLessThanOrEqualTo(Integer value) {
			addCriterion("user_id_cre <=", value, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreIn(List<Integer> values) {
			addCriterion("user_id_cre in", values, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreNotIn(List<Integer> values) {
			addCriterion("user_id_cre not in", values, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreBetween(Integer value1, Integer value2) {
			addCriterion("user_id_cre between", value1, value2, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdCreNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id_cre not between", value1, value2, "userIdCre");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdIsNull() {
			addCriterion("user_id_upd is null");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdIsNotNull() {
			addCriterion("user_id_upd is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdEqualTo(Integer value) {
			addCriterion("user_id_upd =", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdNotEqualTo(Integer value) {
			addCriterion("user_id_upd <>", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdGreaterThan(Integer value) {
			addCriterion("user_id_upd >", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id_upd >=", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdLessThan(Integer value) {
			addCriterion("user_id_upd <", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id_upd <=", value, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdIn(List<Integer> values) {
			addCriterion("user_id_upd in", values, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdNotIn(List<Integer> values) {
			addCriterion("user_id_upd not in", values, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdBetween(Integer value1, Integer value2) {
			addCriterion("user_id_upd between", value1, value2, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andUserIdUpdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id_upd not between", value1, value2, "userIdUpd");
			return (Criteria) this;
		}

		public Criteria andColumnIdIsNull() {
			addCriterion("column_id is null");
			return (Criteria) this;
		}

		public Criteria andColumnIdIsNotNull() {
			addCriterion("column_id is not null");
			return (Criteria) this;
		}

		public Criteria andColumnIdEqualTo(Integer value) {
			addCriterion("column_id =", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdNotEqualTo(Integer value) {
			addCriterion("column_id <>", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdGreaterThan(Integer value) {
			addCriterion("column_id >", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("column_id >=", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdLessThan(Integer value) {
			addCriterion("column_id <", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdLessThanOrEqualTo(Integer value) {
			addCriterion("column_id <=", value, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdIn(List<Integer> values) {
			addCriterion("column_id in", values, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdNotIn(List<Integer> values) {
			addCriterion("column_id not in", values, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdBetween(Integer value1, Integer value2) {
			addCriterion("column_id between", value1, value2, "columnId");
			return (Criteria) this;
		}

		public Criteria andColumnIdNotBetween(Integer value1, Integer value2) {
			addCriterion("column_id not between", value1, value2, "columnId");
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