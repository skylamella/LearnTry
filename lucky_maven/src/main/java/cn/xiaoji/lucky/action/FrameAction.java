package cn.xiaoji.lucky.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.UserService;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.utils.PageBean;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class FrameAction extends ActionSupport {

	private String url;
	private Integer page;
	private Integer rows;
	private String searchText;

	@Resource(name = "userService")
	private UserService userService;

	public String index() {
		return SUCCESS;
	}

	public String userinfo() {
		return SUCCESS;
	}

	public String userprize() {
		return SUCCESS;
	}

	public String useradchk() {
		User u = (User) ActionContext.getContext().getSession().get("user");
		if (u.getUser_admin() == 1) {
			return url;
		} else {
			return "false";
		}
	}

	public String getUserList() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if (CommonUse.nullStringCheck(searchText)) {
			dc.add(Restrictions.like("user_email", "%" + searchText + "%"));
		}
		PageBean pageBean = userService.getPageBean(dc, page, rows);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("total", pageBean.getTotalCount());
		dataMap.put("rows", pageBean.getList());
		String jsonArray = JSON.toJSONString(dataMap);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray);
		return null;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
