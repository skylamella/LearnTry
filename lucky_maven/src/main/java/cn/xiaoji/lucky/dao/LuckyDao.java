package cn.xiaoji.lucky.dao;

import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.utils.BaseDao;

public interface LuckyDao extends BaseDao<Lucky> {

	Lucky findByCode(String code);

}
