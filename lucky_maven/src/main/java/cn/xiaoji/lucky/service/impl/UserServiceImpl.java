package cn.xiaoji.lucky.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.UserDao;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public User checkEmail(String user_email) {
		return userDao.login(user_email);
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}
}
