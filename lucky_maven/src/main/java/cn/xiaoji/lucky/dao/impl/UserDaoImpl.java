package cn.xiaoji.lucky.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.xiaoji.lucky.dao.UserDao;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.BaseDaoImpl;

@Repository(value="userDao")
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
	
}
