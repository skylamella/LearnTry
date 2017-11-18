package cn.xiaoji.lucky.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.LuckyDao;
import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.service.LuckyService;
import cn.xiaoji.lucky.utils.CommonUse;

@Service("luckyService")
public class LuckyServiceImpl implements LuckyService {
	@Resource(name = "luckyDao")
	private LuckyDao luckyDao;

	@Override
	public Lucky checkCode(String code) {
		Lucky lucky = luckyDao.findByCode(code);
		if (CommonUse.nullStringCheck(lucky.getLucky_pwd())) {
			return lucky;
		} else {
			return null;
		}
	}

}
