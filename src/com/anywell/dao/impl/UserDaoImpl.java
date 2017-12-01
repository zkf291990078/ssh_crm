package com.anywell.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.anywell.dao.UserDao;
import com.anywell.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByCode(final String code) {
		// TODO Auto-generated method stub
		// final String Hql="from User where user_code=?";
		// return getHibernateTemplate().execute(new HibernateCallback<User>() {
		//
		// @Override
		// public User doInHibernate(Session session) throws HibernateException
		// {
		// // TODO Auto-generated method stub
		// Query query= session.createQuery(Hql);
		// query.setParameter(0, code);
		// User u= (User) query.uniqueResult();
		// return u;
		// }
		// });
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", code));
		List<User> user = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		if (user != null && user.size() > 0) {
			return user.get(0);
		}
		return null;
	}

	
}
