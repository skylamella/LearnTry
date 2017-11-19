package cn.xiaoji.lucky.dao;

import java.util.List;

import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.BaseDao;

public interface PrizeDao extends BaseDao<Prize> {

	List<Prize> findAllById(Integer lucky_id);

}
