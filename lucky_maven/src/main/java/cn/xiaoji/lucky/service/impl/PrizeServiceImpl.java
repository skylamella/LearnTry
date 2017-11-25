package cn.xiaoji.lucky.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.PrizeDao;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.PrizeService;
import cn.xiaoji.lucky.utils.PageBean;

@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {
	@Resource(name = "prizeDao")
	private PrizeDao prizeDao;

	@Override
	public List<Prize> getAllByLuckyId(Integer lucky_id) {
		return prizeDao.findAllById(lucky_id);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		PageBean pageBean = new PageBean(currentPage, prizeDao.getRowCount(dc), pageSize);
		List<Prize> list = prizeDao.getPageList(dc,pageBean.getCurrentPage(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

}
