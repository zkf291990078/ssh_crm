package com.anywell.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.anywell.dao.CustomerDao;
import com.anywell.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	@SuppressWarnings("all")
	public List<Object[]> getIndustryCount() {
		// TODO Auto-generated method stub
		final String sql = "select bd.dict_item_name, count(*) total from cst_customer c, base_dict bd where bd.dict_id=c.cust_industry group by c.cust_industry";

		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});

		return list;
	}

}
