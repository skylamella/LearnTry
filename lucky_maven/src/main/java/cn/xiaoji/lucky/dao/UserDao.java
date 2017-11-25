package cn.xiaoji.lucky.dao;

import java.util.List;
import java.util.Map;

import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.BaseDao;

public interface UserDao extends BaseDao<User> {
	User login(String user_email);

	List<User> findByIcon(String icon);
	
	Map getMap(Integer currentPage, Integer pageSize, String searchText);
}
