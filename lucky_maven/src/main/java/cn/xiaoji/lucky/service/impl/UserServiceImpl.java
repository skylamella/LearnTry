package cn.xiaoji.lucky.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.dao.UserDao;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.UserService;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.utils.PageBean;

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

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		PageBean pageBean = new PageBean(currentPage, userDao.getRowCount(dc), pageSize);
		List<User> list = userDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}
}
