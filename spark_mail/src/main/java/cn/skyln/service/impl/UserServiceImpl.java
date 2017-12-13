package cn.skyln.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.skyln.dao.UserMapper;
import cn.skyln.pojo.User;
import cn.skyln.pojo.UserExample;
import cn.skyln.service.UserService;
import cn.skyln.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public User findUserByID(Integer User_id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(User_id);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findUserByEmail(UserExample ue) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(ue).get(0);
	}

	@Override
	public PageBean getPageBean(Integer currentPage, Integer pageSize) {
		UserExample example = new UserExample();
		Integer totalCount = userMapper.countByExample(example);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		example.clear();
		example.setCurrentPage(pb.getStart());
		example.setPageSize(pb.getPageSize());
		List<User> list = userMapper.selectByLimit(example);
		pb.setList(list);
		return pb;
	}

}
