package cn.xiaoji.lucky.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.PageBean;

public interface PrizeService {

	List<Prize> getAllByLuckyId(Integer lucky_id);
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
