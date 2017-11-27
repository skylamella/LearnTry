package lucky_maven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.service.LuckyService;
import cn.xiaoji.lucky.service.MailService;
import cn.xiaoji.lucky.service.PrizeService;
import cn.xiaoji.lucky.service.ResultService;
import cn.xiaoji.lucky.service.UserService;
import cn.xiaoji.lucky.utils.CommonUse;
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
	@Resource(name = "mailService")
	private MailService mailService;
	@Resource(name = "luckyService")
	private LuckyService luckyService;
	@Resource(name = "prizeService")
	private PrizeService prizeService;
	@Resource(name = "resultService")
	private ResultService resultService;
	
	@Test
	public void test() {
		Prize prize = new Prize();
		String Code = CommonUse.MD5Password("123456");
		prize.setLucky(luckyService.checkCode(Code));
		prize.setPrize_grade(3);
		prize.setPrize_name("奖品三");
		prize.setPrize_nums(3);
		prizeService.save(prize);
	}
	@Test
	public void test2() {
		String Code = CommonUse.MD5Password("123456");
		Lucky lucky = luckyService.checkCode(Code);
		List<Prize> list = prizeService.getAllByLucky(lucky);
		System.out.println(list.get(0).getPrize_name());
	}
	@Test
	public void test3() {
		String Code = CommonUse.MD5Password("123456");
		Lucky lucky = luckyService.checkCode(Code);
		List<Prize> list = prizeService.getAllByLucky(lucky);
		System.out.println(list.get(0).getPrize_name());
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
