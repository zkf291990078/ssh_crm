package com.anywell.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.anywell.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;

	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) pType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		T t = getById(id);
		delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		// TODO Auto-generated method stub
		T t = (T) getHibernateTemplate().get(clazz, id);
		return t;
	}

	@Override
	public Integer getTotalCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		criteria.setProjection(null);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		} else {
			return null;
		}

	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
	}

}
