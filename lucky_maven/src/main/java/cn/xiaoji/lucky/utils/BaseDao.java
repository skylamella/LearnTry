package cn.xiaoji.lucky.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/**
	 * 保存对象
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 修改对象
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 删除对象
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	/**
	 * 查询多个ID，返回一个list
	 * @param ids
	 * @return
	 */
	List<T> findByIDs(final Integer[] ids);
	/**
	 * 查询一个ID，返回一个对象
	 * @param id
	 * @return
	 */
	T findByID(Integer id);
	/**
	 * 分页查询数据，返回一个list
	 * @return
	 */
	List<T> findAllByLimit(final int limitBeginNum, final int limitMaxNum);
	/**
	 * 查询当前表中的所有行数，返回一个int
	 * @return
	 */
	Integer getRowCount(DetachedCriteria dc);
	
	List<T> getPageList(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
}
