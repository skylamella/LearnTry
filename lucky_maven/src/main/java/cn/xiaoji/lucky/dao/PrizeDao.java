package cn.xiaoji.lucky.dao;

import java.util.List;
import java.util.Map;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.BaseDao;

public interface PrizeDao extends BaseDao<Prize> {

	Map getMap(Integer currentPage, Integer pageSize, String searchText);

	List<Prize> findAllByLucky(Lucky lucky);
}
