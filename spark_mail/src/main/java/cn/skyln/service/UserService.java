package cn.skyln.service;

import cn.skyln.pojo.User;

public interface UserService {
	User findUserByID(Integer User_id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	
}
