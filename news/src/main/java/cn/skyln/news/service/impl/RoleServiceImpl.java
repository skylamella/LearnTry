package cn.skyln.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.skyln.news.dao.RoleMapper;
import cn.skyln.news.pojo.Role;
import cn.skyln.news.pojo.RoleExample;
import cn.skyln.news.service.RoleService;
import cn.skyln.news.utils.PageBean;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Override
	public PageBean getPageBean(Integer currentPage, Integer pageSize, RoleExample example) {
		Integer totalCount = roleMapper.countByExample(example);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		example.setCurrentPage(pb.getStart());
		example.setPageSize(pb.getPageSize());
		List<Role> list = roleMapper.selectByLimit(example);
		pb.setList(list);
		return pb;
	}

}
