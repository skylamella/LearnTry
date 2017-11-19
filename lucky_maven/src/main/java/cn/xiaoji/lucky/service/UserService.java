package cn.xiaoji.lucky.service;

import java.util.List;

import cn.xiaoji.lucky.entity.User;

public interface UserService {

	User checkEmail(String user_email);

	void update(User u);

	List<User> getAll();

	void save(User u);

	List<User> findByIcon(String icon);

}
