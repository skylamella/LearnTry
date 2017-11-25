package cn.xiaoji.lucky.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.LuckyDao;
import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.LuckyService;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.utils.PageBean;

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

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		PageBean pageBean = new PageBean(currentPage, luckyDao.getRowCount(dc), pageSize);
		List<Lucky> list = luckyDao.getPageList(dc,pageBean.getCurrentPage(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

}
