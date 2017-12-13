package cn.skyln.service;

import cn.skyln.pojo.User;
import cn.skyln.pojo.UserExample;
import cn.skyln.utils.PageBean;

public interface UserService {
	User findUserByID(Integer User_id);
	
	void saveUser(User user);
	
	void updateUser(User user);

	User findUserByEmail(UserExample ue);

	PageBean getPageBean(Integer currentPage, Integer pageSize);
	
	
}
