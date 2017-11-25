package cn.xiaoji.lucky.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.ResultDao;
import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.ResultService;
import cn.xiaoji.lucky.utils.PageBean;

@Service("resultService")
public class ResultServiceImpl implements ResultService {
	@Resource(name = "resultDao")
	private ResultDao resultDao;
	@Override
	public void save(Result re) {
		resultDao.save(re);
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		PageBean pageBean = new PageBean(currentPage, resultDao.getRowCount(dc), pageSize);
		List<Result> list = resultDao.getPageList(dc,pageBean.getCurrentPage(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

}
