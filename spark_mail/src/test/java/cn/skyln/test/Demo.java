package cn.skyln.test;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.skyln.dao.UserMapper;
import cn.skyln.pojo.User;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class Demo extends TestCase {
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void test() throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSEssion帮我生成一个实现类 （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserById(1);
		System.out.println(user.getUser_name());
	}
}
