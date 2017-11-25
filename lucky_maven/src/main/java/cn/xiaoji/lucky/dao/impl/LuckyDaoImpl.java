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

import cn.xiaoji.lucky.dao.LuckyDao;
import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.utils.BaseDaoImpl;
import cn.xiaoji.lucky.utils.PageBean;
@Repository(value="luckyDao")
@SuppressWarnings("unchecked")
public class LuckyDaoImpl extends BaseDaoImpl<Lucky> implements LuckyDao {

	@Override
	public Lucky findByCode(final String code) {
		return getHibernateTemplate().execute(new HibernateCallback<Lucky>() {
			@Override
			public Lucky doInHibernate(Session session) throws HibernateException {
				return (Lucky)session.createCriteria(clazz).add(Restrictions.eq("lucky_pwd", code)).uniqueResult();
			}
		});
	}

	@Override
	public Map getMap(Integer currentPage, Integer pageSize, String searchText) {
		return getHibernateTemplate().execute(new HibernateCallback<Map>() {
			@Override
			public Map doInHibernate(Session session) throws HibernateException {
				List<Lucky> list = null;
				if (searchText == null || searchText == "") {
					list = session.createCriteria(clazz).setFirstResult(currentPage).setMaxResults(pageSize)
							.addOrder(Order.asc("lucky_id")).list();
				} else {
					list = session.createCriteria(clazz).add(Restrictions.like("lucky_title", "%" + searchText + "%"))
							.setFirstResult(currentPage).setMaxResults(pageSize).addOrder(Order.asc("lucky_id")).list();
				}
				Map map = new HashMap();
				Integer i = list.size();
				map.put("totalCount", i);
				map.put("list", list);
				return map;
			}
		});
	}

}
