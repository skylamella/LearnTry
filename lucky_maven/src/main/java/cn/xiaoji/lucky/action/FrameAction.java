package cn.xiaoji.lucky.action;

import java.io.File;
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

import cn.xiaoji.lucky.entity.*;
import cn.xiaoji.lucky.service.*;
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
	private User user;
	private Lucky lucky;
	private Result result;
	private Prize prize;
	private File upload;// 上传的文件
	private String uploadFileName;// 上传的文件名陈

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "luckyService")
	private LuckyService luckyService;
	@Resource(name = "prizeService")
	private PrizeService prizeService;
	@Resource(name = "resultService")
	private ResultService resultService;

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

	public String userAdd() throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		String upFileName = null;
		if(upload != null){
			upFileName = CommonUse.generateFileName(uploadFileName);
			String uploadFilePath = ServletActionContext.getServletContext().getRealPath("/images/icon");
			String path = uploadFilePath + "\\" + upFileName;
			upload.renameTo(new File(path));
		}
		
		try {
			if (user.getUser_id() != null) {
				User u = userService.findById(user.getUser_id());
				if (!u.getUser_pwd().equals(user.getUser_pwd())) {
					user.setUser_pwd(CommonUse.MD5Password(user.getUser_pwd()));
				}
				user.setUser_chk(u.getUser_chk());
				if(upload != null){
					user.setUser_icon(upFileName);
				}else{
					user.setUser_icon(u.getUser_icon());
				}
				userService.update(user);
			} else {
				user.setUser_chk(1);
				user.setUser_icon(upFileName);
				user.setUser_pwd(CommonUse.MD5Password(user.getUser_pwd()));
				userService.save(user);
			}
			dataMap.put("code", "success");
		} catch (Exception e) {
			dataMap.put("code", "false");
		}
		String jsonArray = JSON.toJSONString(dataMap);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray);
		return null;
	}

	public String userSearch() throws Exception {
		User u = userService.findById(user.getUser_id());
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user.user_id", u.getUser_id());
		dataMap.put("user.user_name", u.getUser_name());
		dataMap.put("user.user_email", u.getUser_email());
		dataMap.put("user.user_admin", u.getUser_admin());
		dataMap.put("user.user_pwd", u.getUser_pwd());
		String jsonArray = JSON.toJSONString(dataMap);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray);
		return null;
	}

	public String userDel() throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		User u = userService.findById(user.getUser_id());
		u.setUser_chk(0);
		try {
			userService.update(u);
			dataMap.put("code", "success");
		} catch (Exception e) {
			dataMap.put("code", "false");
		}
		String jsonArray = JSON.toJSONString(dataMap);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray);
		return null;
	}
	public String userReDel() throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		User u = userService.findById(user.getUser_id());
		if (u.getUser_chk() == 1) {
			dataMap.put("code", "false");
			dataMap.put("text", "该账号为正常账号");
		} else {
			u.setUser_chk(1);
			try {
				userService.update(u);
				dataMap.put("code", "success");
			} catch (Exception e) {
				dataMap.put("code", "false");
				dataMap.put("text", "解锁账号失败，请重试！");
			}
		}
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lucky getLucky() {
		return lucky;
	}

	public void setLucky(Lucky lucky) {
		this.lucky = lucky;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
