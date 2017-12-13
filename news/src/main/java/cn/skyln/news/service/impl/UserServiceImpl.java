package cn.skyln.news.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.skyln.news.dao.UserMapper;
import cn.skyln.news.pojo.User;
import cn.skyln.news.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public User findUserByID(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
