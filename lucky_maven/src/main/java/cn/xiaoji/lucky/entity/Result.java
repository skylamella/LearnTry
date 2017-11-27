package cn.xiaoji.lucky.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Result {
	private Integer result_id;
	@JSONField(serialize=false)
	private User user;
	@JSONField(serialize=false)
	private Prize prize;
	@JSONField(serialize=false)
	private Lucky lucky;

	public Integer getResult_id() {
		return result_id;
	}

	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Lucky getLucky() {
		return lucky;
	}

	public void setLucky(Lucky lucky) {
		this.lucky = lucky;
	}

}
