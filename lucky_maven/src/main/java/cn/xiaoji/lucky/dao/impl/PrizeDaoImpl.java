package cn.xiaoji.lucky.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.xiaoji.lucky.dao.PrizeDao;
import cn.xiaoji.lucky.entity.Prize;
import cn.xiaoji.lucky.utils.BaseDaoImpl;

@Repository(value="prizeDao")
public class PrizeDaoImpl extends BaseDaoImpl<Prize> implements PrizeDao {

	@Override
	public List<Prize> findAllById(final Integer lucky_id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Prize>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Prize> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(clazz).add(Restrictions.eq("lucky_id", lucky_id)).addOrder(Order.asc("prize_grade")).list();
			}
		});
	}

}
