package cn.xiaoji.lucky.service.impl;

import java.util.List;

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

	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User u) {
		userDao.save(u);
	}

	@Override
	public List<User> findByIcon(String icon) {
		return userDao.findByIcon(icon);
	}
}
