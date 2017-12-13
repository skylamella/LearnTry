package cn.skyln.news.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.skyln.news.pojo.User;
import cn.skyln.news.service.UserService;

@Controller
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/findOneUser")
	@ResponseBody
	public String findOneUser(){
		User user = userService.findUserByID(1);
		System.out.println(user.getUserEmail());
		return user.getUserEmail();
	}

}
