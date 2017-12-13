package cn.skyln.news.service;

import java.util.List;

import cn.skyln.news.pojo.User;
import cn.skyln.news.pojo.UserExample;
import cn.skyln.news.utils.PageBean;

public interface UserService {

	public User findUserByID(Integer id);
	
	public PageBean getPageBean(Integer currentPage, Integer pageSize, UserExample example);
	
	public void updateUser(User user);
	
	public void saveUser(User user);
	
	public List<User> findAllUser();
}
