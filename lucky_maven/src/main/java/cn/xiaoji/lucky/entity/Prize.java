package cn.xiaoji.lucky.entity;

public class Prize {
	private Integer prize_id;
	private String prize_name;
	private int prize_nums;
	private int prize_grade;
	private int lucky_id;

	public Integer getPrize_id() {
		return prize_id;
	}

	public void setPrize_id(Integer prize_id) {
		this.prize_id = prize_id;
	}

	public String getPrize_name() {
		return prize_name;
	}

	public void setPrize_name(String prize_name) {
		this.prize_name = prize_name;
	}

	public int getPrize_nums() {
		return prize_nums;
	}

	public void setPrize_nums(int prize_nums) {
		this.prize_nums = prize_nums;
	}

	public int getPrize_grade() {
		return prize_grade;
	}

	public void setPrize_grade(int prize_grade) {
		this.prize_grade = prize_grade;
	}

	public int getLucky_id() {
		return lucky_id;
	}

	public void setLucky_id(int lucky_id) {
		this.lucky_id = lucky_id;
	}
}