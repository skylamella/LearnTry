package cn.xiaoji.lucky.dao;

import java.util.List;
import java.util.Map;

import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.utils.BaseDao;

public interface ResultDao extends BaseDao<Result> {
	
	Map getMap(Integer currentPage, Integer pageSize, String searchText);
}
