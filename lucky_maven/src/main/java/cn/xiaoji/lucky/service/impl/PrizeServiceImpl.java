package cn.xiaoji.lucky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.PrizeDao;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.service.PrizeService;

@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {
	@Resource(name = "prizeDao")
	private PrizeDao prizeDao;

	@Override
	public List<Prize> getAllByLuckyId(Integer lucky_id) {
		return prizeDao.findAllById(lucky_id);
	}

}
