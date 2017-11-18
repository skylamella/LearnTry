package cn.xiaoji.lucky.utils;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private SessionFactory sessionFactory;
	protected Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(findByID(id));
	}
	@Override
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(clazz).addOrder(Order.asc(clazz.getSimpleName() + "_id")).list();
			}
		});
	}
	@Override
	public List<T> findByIDs(final Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(clazz).add(Restrictions.in(clazz.getSimpleName() + "_id", ids))
						.addOrder(Order.asc(clazz.getSimpleName() + "_id")).list();
			}
		});
	}
	@Override
	public T findByID(Integer id) {
		return (T) getHibernateTemplate().execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException {
				return session.load(clazz, id);
			}
		});
	}
	@Override
	public List<T> findAllByLimit(final int limitBeginNum, final int limitMaxNum) {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(clazz).addOrder(Order.asc(clazz.getSimpleName() + "_id"))
						.setFirstResult(limitBeginNum).setMaxResults(limitMaxNum).list();
			}
		});
	}
	@Override
	public int getRowCount() {
		return (int) findAll().size();
	}

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
