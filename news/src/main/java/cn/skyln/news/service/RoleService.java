package cn.skyln.news.service;

import cn.skyln.news.pojo.RoleExample;
import cn.skyln.news.utils.PageBean;

public interface RoleService {
	public PageBean getPageBean(Integer currentPage, Integer pageSize, RoleExample example);
}
