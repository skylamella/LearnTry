package cn.xiaoji.lucky.dao;

import java.util.List;
import java.util.Map;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.utils.BaseDao;

public interface LuckyDao extends BaseDao<Lucky> {

	Lucky findByCode(String code);
	
	Map getMap(Integer currentPage, Integer pageSize, String searchText);
}
