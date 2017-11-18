package cn.xiaoji.lucky.service;

import cn.xiaoji.lucky.entity.User;

public interface UserService {

	User checkEmail(String user_email);

	void update(User u);

}
