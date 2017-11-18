package cn.xiaoji.lucky.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.xiaoji.lucky.dao.LuckyDao;
import cn.xiaoji.lucky.entity.Lucky;
import cn.xiaoji.lucky.utils.BaseDaoImpl;
@Repository(value="luckyDao")
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

}
