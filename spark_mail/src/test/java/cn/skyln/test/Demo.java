package cn.skyln.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.skyln.dao.UserMapper;
import cn.skyln.service.UserService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class Demo extends TestCase {
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserService userService;
	@Test
	public void test() throws Exception {
		
	}
}
