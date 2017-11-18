package cn.xiaoji.lucky.dao;

import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.BaseDao;

public interface UserDao extends BaseDao<User> {
	User login(String user_email);
}
