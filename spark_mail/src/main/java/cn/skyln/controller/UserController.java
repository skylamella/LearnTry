package cn.skyln.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import cn.skyln.pojo.User;
import cn.skyln.service.UserService;
import cn.skyln.utils.PageBean;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request, HttpServletResponse resp) throws Exception{
		Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
		Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageBean pb =  userService.getPageBean(currentPage, pageSize);
			map.put("code", "success");
			map.put("total", pb.getTotalCount());
			map.put("rows", pb.getList());
		} catch (Exception e) {
			map.put("code", "false");
		}
		String json = JSON.toJSONString(map);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().write(json);
        return null;
    }
	@RequestMapping("/findOneUser")
	public String findOneUser(HttpServletRequest request,Integer id,HttpServletResponse resp) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user =  userService.findUserByID(id);
			map.put("code", "success");
			map.put("user", user);
		} catch (Exception e) {
			map.put("code", "false");
		}
		String json = JSON.toJSONString(map);
		resp.setContentType("application/json;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		resp.getWriter().write(json);
		return null;
	}
}
