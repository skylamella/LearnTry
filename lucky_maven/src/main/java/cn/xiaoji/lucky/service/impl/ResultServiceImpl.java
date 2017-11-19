package cn.xiaoji.lucky.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.ResultDao;
import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.service.ResultService;

@Service("resultService")
public class ResultServiceImpl implements ResultService {
	@Resource(name = "resultDao")
	private ResultDao resultDao;
	@Override
	public void save(Result re) {
		resultDao.save(re);
	}

}
