/**
 * Create Date: 2012-1-31<br>
 * File Name: BaseDao.java
 */
package org.suren.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.suren.util.Page;


/**
 * @author Administrator<br>
 * Create Time: 05:01:11<br>
 * 数据库基本操作，包括事务以及分页查询功能。
 * 注意：必须在实现的抽象方法中设置当前子类代表的实体类
 */
@Transactional
public abstract class BaseDao<T>
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<?> entity;
	
	public abstract Class<?> setClass();
	
	public BaseDao()
	{
		entity = setClass();
	}
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	protected Criteria getCritera()
	{
		return getSession().createCriteria(entity);
	}
	
	public Query getQuery(String hql)
	{
		return getSession().createQuery(hql);
	}
	
	public void save(T entity)
	{
		getSession().save(entity);
	}
	
	public void update(T entity)
	{
		getSession().update(entity);
	}
	
	public void update(T entity, boolean save)
	{
		if(save)
		{
			getSession().saveOrUpdate(entity);
		}
		else
		{
			update(entity);
		}
	}
	
	public void delete(T entity)
	{
		getSession().delete(entity);
	}
	
	public void deleteById(Serializable id)
	{
		delete(findById(id));
	}
	
	public T findById(Serializable id)
	{
		return (T) getSession().get(entity, id);
	}
	
	public T findById(Serializable id, boolean proxy)
	{
		return proxy ? (T) getSession().load(entity, id) : findById(id);
	}
	
	public List<T> findAll()
	{
		Criteria critera = getCritera();
		
		return critera.list();
	}
	
	public void findByCriteria(Criteria criteria, Page<T> page)
	{
		Integer total = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		
		criteria.setProjection(null);
		
		page.setTotal(total + 1);
		
		criteria.setFirstResult(page.getStart());
		criteria.setMaxResults(page.getLimit());
		
		page.setResult(criteria.list());
	}
	
	public List<T> findByCriteria(Criteria criteria)
	{
		return criteria.list();
	}
	
	public void findBySQL(String hql, String totalHql, Page<T> page)
	{
		Query query = getSession().createQuery(hql);
		
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getLimit());
		
		page.setResult(query.list());
		
		query = getSession().createQuery(totalHql);
		
		page.setTotal((Integer) query.uniqueResult());
	}
	
	public List<T> findBySQL(String hql)
	{
		Query query = getSession().createQuery(hql);
		
		return query.list();
	}
	
	public List<T> findBySQL(String hql, List<Object> params)
	{
		Query query = getSession().createQuery(hql);
		
		for(int i = 0; i < params.size(); i++)
		{
			query.setParameter(0, params.get(i));
		}

		return query.list();
	}
	
}
