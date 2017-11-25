package cn.xiaoji.lucky.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@SuppressWarnings("unchecked")
public class PrizeDaoImpl extends BaseDaoImpl<Prize> implements PrizeDao {

	@Override
	public List<Prize> findAllById(final Integer lucky_id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Prize>>() {
			@Override
			public List<Prize> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(clazz).add(Restrictions.eq("lucky_id", lucky_id)).addOrder(Order.asc("prize_grade")).list();
			}
		});
	}

	@Override
	public Map getMap(final Integer currentPage, final Integer pageSize, final String searchText) {
		return getHibernateTemplate().execute(new HibernateCallback<Map>() {
			@Override
			public Map doInHibernate(Session session) throws HibernateException {
				Map map = new HashMap();
				List<Prize> list = null;
				if (searchText == null || searchText == "") {
					list = session.createCriteria(clazz).setFirstResult(currentPage).setMaxResults(pageSize)
							.addOrder(Order.asc("prize_id")).list();
				} else {
					list = session.createCriteria(clazz).add(Restrictions.like("prize_name", "%" + searchText + "%"))
							.setFirstResult(currentPage).setMaxResults(pageSize).addOrder(Order.asc("prize_id")).list();
				}
				Integer i = list.size();
				map.put("totalCount", i);
				map.put("list", list);
				return map;
			}
		});
	}

}
