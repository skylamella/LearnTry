package cn.xiaoji.lucky.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.service.LuckyService;
import cn.xiaoji.lucky.service.PrizeService;
import cn.xiaoji.lucky.service.UserService;
import cn.xiaoji.lucky.utils.CommonUse;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LuckyAction extends ActionSupport {

	@Resource(name = "luckyService")
	private LuckyService luckyService;
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "prizeService")
	private PrizeService prizeService;

	public String lucky() {
		//判断是否验证过活动开启密码
		if(CommonUse.nullStringCheck((String) ActionContext.getContext().getSession().get("openCode"))){
			//从数据库中读取各种各样的数据
			String openCode = (String) ActionContext.getContext().getSession().get("openCode");
			Lucky lucky = luckyService.checkCode(openCode);
			List<User> ulist = userService.getAll();
			User u = ulist.get(0);
			List<Prize> plist = prizeService.getAllByLuckyId(lucky.getLucky_id());
			
			//将需要在前台显示的数据以键值对的方式放在session域里
			ActionContext.getContext().getSession().put("lucky", lucky);
			ActionContext.getContext().getSession().put("userList", ulist);
			ActionContext.getContext().getSession().put("firstuser", u);
			
			ActionContext.getContext().getSession().put("firstprize", plist.get(0));
			ActionContext.getContext().getSession().put("secontprize", plist.get(1));
			ActionContext.getContext().getSession().put("thirdprize", plist.get(2));
			return SUCCESS;
		}else{
			return "index";
		}
	}
}
