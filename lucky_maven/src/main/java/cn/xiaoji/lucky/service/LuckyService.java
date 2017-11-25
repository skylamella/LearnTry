package cn.xiaoji.lucky.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.utils.PageBean;

public interface LuckyService {

	Lucky checkCode(String code);
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
