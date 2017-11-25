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

import cn.xiaoji.lucky.dao.ResultDao;
import cn.xiaoji.lucky.entity.Result;
import cn.xiaoji.lucky.utils.BaseDaoImpl;

@Repository(value = "resultDao")
@SuppressWarnings("unchecked")
public class ResultDaoImpl extends BaseDaoImpl<Result> implements ResultDao {

	@Override
	public Map getMap(final Integer currentPage, final Integer pageSize, final String searchText) {
		return getHibernateTemplate().execute(new HibernateCallback<Map>() {
			@Override
			public Map doInHibernate(Session session) throws HibernateException {
				List<Result> list = null;
				if (searchText == null || searchText == "") {
					list = session.createCriteria(clazz).setFirstResult(currentPage).setMaxResults(pageSize)
							.addOrder(Order.asc("result_id")).list();
				} else {
					list = session.createCriteria(clazz).add(Restrictions.like("lucky_id", "%" + searchText + "%"))
							.setFirstResult(currentPage).setMaxResults(pageSize).addOrder(Order.asc("result_id")).list();
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
