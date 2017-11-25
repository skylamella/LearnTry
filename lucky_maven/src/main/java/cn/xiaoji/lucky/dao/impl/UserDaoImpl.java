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

import cn.xiaoji.lucky.dao.UserDao;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.BaseDaoImpl;

@Repository(value="userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(final String user_email) {
		return getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				return (User)session.createCriteria(clazz).add(Restrictions.eq("user_email", user_email)).uniqueResult();
			}
		});
	}

	@Override
	public List<User> findByIcon(final String icon) {
		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				return (List<User>)session.createCriteria(clazz).add(Restrictions.eq("user_icon", icon)).list();
			}
		});
	}

	@Override
	public Map getMap(final Integer currentPage, final Integer pageSize, final String searchText) {
		System.out.println("daobegin");
		return getHibernateTemplate().execute(new HibernateCallback<Map>() {
			@Override
			public Map doInHibernate(Session session) throws HibernateException {
				List<User> list = null;
				if (searchText == null || searchText == "") {
					System.out.println("CriteriaBegin");
					list = (List<User>)session.createCriteria(clazz).setFirstResult(currentPage).setMaxResults(pageSize)
							.addOrder(Order.asc("user_id")).list();
					System.out.println("Criteriaend");
				} else {
					list = (List<User>)session.createCriteria(clazz).add(Restrictions.like("user_name", "%" + searchText + "%"))
							.setFirstResult(currentPage).setMaxResults(pageSize).addOrder(Order.asc("user_id")).list();
				}
				Map map = new HashMap();
				Integer i = list.size();
				map.put("totalCount", i);
				map.put("list", list);
				System.out.println("daoend");
				return map;
			}
		});
	}
	
}
