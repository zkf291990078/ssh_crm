package com.anywell.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.dao.BaseDictDao;
import com.anywell.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
