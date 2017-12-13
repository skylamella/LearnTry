package cn.skyln.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.skyln.news.dao.UserMapper;
import cn.skyln.news.pojo.User;
import cn.skyln.news.pojo.UserExample;
import cn.skyln.news.service.UserService;
import cn.skyln.news.utils.PageBean;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public User findUserByID(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public PageBean getPageBean(Integer currentPage, Integer pageSize, UserExample example) {
		Integer totalCount = userMapper.countByExample(example);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		example.setCurrentPage(pb.getStart());
		example.setPageSize(pb.getPageSize());
		List<User> list = userMapper.selectByLimit(example);
		pb.setList(list);
		return pb;
	}
	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public void saveUser(User user) {
		userMapper.insert(user);
	}
	@Override
	public List<User> findAllUser() {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

}
