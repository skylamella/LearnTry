package cn.xiaoji.lucky.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Result {
	private Integer result_id;
	@JSONField(serialize=false)
	private Integer user_id;
	@JSONField(serialize=false)
	private Integer prize_id;
	@JSONField(serialize=false)
	private Integer lucky_id;

	public Integer getResult_id() {
		return result_id;
	}

	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPrize_id() {
		return prize_id;
	}

	public void setPrize_id(Integer prize_id) {
		this.prize_id = prize_id;
	}

	public Integer getLucky_id() {
		return lucky_id;
	}

	public void setLucky_id(Integer lucky_id) {
		this.lucky_id = lucky_id;
	}
}
