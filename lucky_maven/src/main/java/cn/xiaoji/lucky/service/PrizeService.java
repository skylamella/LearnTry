package cn.xiaoji.lucky.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.PageBean;

public interface PrizeService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Prize prize);

	List<Prize> getAllByLucky(Lucky lucky);

}
