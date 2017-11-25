package cn.xiaoji.lucky.utils;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
				return session.createCriteria(clazz).list();
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
				return session.createCriteria(clazz).add(Restrictions.in(clazz.getSimpleName() + "_id", ids)).list();
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
				return session.createCriteria(clazz).setFirstResult(limitBeginNum).setMaxResults(limitMaxNum).list();
			}
		});
	}

	@Override
	public Integer getRowCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}

	public List<T> getPageList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, currentPage, pageSize);
		return list;
	}
	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
