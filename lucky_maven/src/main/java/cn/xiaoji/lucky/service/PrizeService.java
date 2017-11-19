package cn.xiaoji.lucky.service;

import java.util.List;

import cn.xiaoji.lucky.entity.Prize;

public interface PrizeService {

	List<Prize> getAllByLuckyId(Integer lucky_id);

}
