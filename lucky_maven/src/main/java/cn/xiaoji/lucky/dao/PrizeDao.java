package cn.xiaoji.lucky.dao;

import java.util.List;
import java.util.Map;

import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.BaseDao;

public interface PrizeDao extends BaseDao<Prize> {

	List<Prize> findAllById(Integer lucky_id);
	
	Map getMap(Integer currentPage, Integer pageSize, String searchText);

}
