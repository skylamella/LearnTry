package cn.xiaoji.lucky.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.xiaoji.lucky.entity.*;
import cn.xiaoji.lucky.service.*;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.utils.PageBean;
import cn.xiaoji.lucky.vo.Mail;

/***
 * AjaxAction 实现ajax前后端数据交互，返回json字符串，在前台需要进行格式化
 * 
 * 如果前台有需要提交的字段（form表单中） 在方法依赖字段按照相应的类型创建private字段，然后生成get，set方法即可
 * 不需要通过request、response进行数据获取
 * 
 * 返回为String类型的字符串，在方法中创建hashmap，将相应字段放入hashmap中 然后进行类型转换即可
 * 
 * 切记将转换完的数据赋值给jsonArray字段，该字段为系统自动读取并返回给前台的数据
 * 
 * @author lamella
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AjaxAction extends ActionSupport {
	// 方法依赖字段
	private String email;
	private String jsonArray;
	private String openCode;
	private User user;
	private String icon;
	private int times;
	private Integer currentPage;
	private Integer pageSize;
	private String searchText;

	// Service层动态代理
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

	//user操作方法
	public String emailCheck() {
		HashMap<String, String> map = new HashMap<String, String>();
		User u = userService.checkEmail(email);
		if (CommonUse.nullStringCheck(u.getUser_name())) {
			map.put("code", "success");
		} else {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String emailCreate() {
		HashMap<String, String> map = new HashMap<String, String>();
		User u = userService.checkEmail(email);
		String emailAccount = "admin@skyln.cn";
		Mail mail = CommonUse.createCheckEmail(emailAccount, email, u.getUser_name());
		try {
			mailService.sendMail(mail);
			map.put("code", "success");
			map.put("CheckCode", mail.getCheckCode());
		} catch (Exception e) {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String forgetpwd() {
		HashMap<String, String> map = new HashMap<String, String>();
		String newPWD = CommonUse.MD5Password(user.getUser_pwd());
		User u = userService.checkEmail(email);
		u.setUser_pwd(newPWD);
		try {
			userService.update(u);
			map.put("code", "success");
			map.put("text", "修改密码成功，请登录");
		} catch (Exception e) {
			map.put("code", "false");
			map.put("text", "修改密码失败，请重试");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String luckyResult() {
		HashMap<String, String> map = new HashMap<String, String>();
		List<User> ulist = userService.findByIcon(icon);
		if (ulist.size() == 1) {
			String openCode = (String) ActionContext.getContext().getSession().get("openCode");
			Lucky lucky = luckyService.checkCode(openCode);
			List<Prize> plist = prizeService.getAllByLucky(lucky);
			Prize prize = null;
			if (times <= 3) {
				// 三等奖
				prize = plist.get(2);
			} else if (times <= 5) {
				// 二等奖
				prize = plist.get(1);
			} else {
				// 一等奖
				prize = plist.get(0);
			}
			Result re = new Result();
			re.setLucky(lucky);
			re.setUser(ulist.get(0));
			re.setPrize(prize);
			try {
				resultService.save(re);
				map.put("code", "success");
				map.put("user_name", ulist.get(0).getUser_name());
			} catch (Exception e) {
				map.put("code", "false");
			}
		} else {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String getPassCode() {
		HashMap<String, String> map = new HashMap<String, String>();
		if (CommonUse.nullStringCheck((String) ActionContext.getContext().getSession().get("checkCode"))) {
			String passcode = (String) ActionContext.getContext().getSession().get("checkCode");
			map.put("code", "success");
			map.put("passcode", passcode);
		} else {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String uselogin() {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			System.out.println(user.getUser_email());
			User u = userService.checkEmail(user.getUser_email());
			if (u.getUser_chk() == 1) {
				if (u.getUser_pwd().equals(CommonUse.MD5Password(user.getUser_pwd()))) {
					map.put("code", "success");
					ActionContext.getContext().getSession().put("user", u);
				} else {
					map.put("code", "false");
					map.put("text", "账号不存在或账号密码错误，请重试");
				}
			} else {
				map.put("code", "false");
				map.put("text", "账号已被锁定，无法登陆，请联系管理员");
			}
		} catch (Exception e) {
			map.put("code", "false");
			map.put("text", "账号不存在或账号密码错误，请重试");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String changepwd() {
		HashMap<String, String> map = new HashMap<String, String>();
		User u = (User) ActionContext.getContext().getSession().get("user");
		u.setUser_pwd(CommonUse.MD5Password(user.getUser_pwd()));
		try {
			userService.update(u);
			map.put("code", "success");
		} catch (Exception e) {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	public String loginout() {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			ActionContext.getContext().getSession().clear();
			map.put("code", "success");
		} catch (Exception e) {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	//lucky对象操作方法
	public String openCode() {
		HashMap<String, String> map = new HashMap<String, String>();
		String Code = CommonUse.MD5Password(openCode);
		Lucky lucky = luckyService.checkCode(Code);
		if (lucky != null) {
			String url = "/lucky/lucky.xhtml";
			ActionContext.getContext().getSession().put("openCode", Code);
			map.put("code", "success");
			map.put("url", url);
		} else {
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	//prize对象操作方法
	
	//result对象操作方法
	
	/***
	 * get，set方法
	 */
	public String getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(String jsonArray) {
		this.jsonArray = jsonArray;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
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

	public PrizeService getPrizeService() {
		return prizeService;
	}

	public void setPrizeService(PrizeService prizeService) {
		this.prizeService = prizeService;
	}
}