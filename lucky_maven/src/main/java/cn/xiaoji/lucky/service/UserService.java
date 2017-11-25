package cn.xiaoji.lucky.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.PageBean;

public interface UserService {

	User checkEmail(String user_email);

	void update(User u);

	List<User> getAll();

	void save(User u);

	List<User> findByIcon(String icon);
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
