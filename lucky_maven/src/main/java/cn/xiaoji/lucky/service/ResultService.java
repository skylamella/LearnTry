package cn.xiaoji.lucky.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.utils.PageBean;

public interface ResultService {

	void save(Result re);
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
