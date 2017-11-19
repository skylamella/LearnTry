package cn.xiaoji.lucky.dao.impl;

import org.springframework.stereotype.Repository;

import cn.xiaoji.lucky.dao.ResultDao;
import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.utils.BaseDaoImpl;

@Repository(value = "resultDao")
public class ResultDaoImpl extends BaseDaoImpl<Result> implements ResultDao {

}
