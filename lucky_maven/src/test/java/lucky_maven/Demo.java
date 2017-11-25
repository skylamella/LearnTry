package lucky_maven;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.xiaoji.lucky.service.UserService;
import cn.xiaoji.lucky.utils.PageBean;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo extends TestCase {
	private Integer currentPage;
	private Integer pageSize;
	private String searchText;
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Resource(name = "userService")
	private UserService userService;
	@Test
	public void test() {
		/*PageBean pageBean = userService.getPageBean(currentPage, pageSize, searchText);
		Map map = new HashMap();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		String jsonArray = JSON.toJSONString(map);
		System.out.println(pageBean.getTotalCount());
		System.out.println(jsonArray);*/
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}
