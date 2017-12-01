package com.anywell.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.dao.CustomerDao;
import com.anywell.domain.Customer;
import com.anywell.domain.PageBean;
import com.anywell.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Override
	public PageBean getCustomerList(DetachedCriteria criteria, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub

		Integer totalCount = customerDao.getTotalCount(criteria);
		PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
		List<Customer> list = customerDao.getPageList(criteria, pageBean.getstartIndex(), pageBean.getPageSize());
		pageBean.setList(list);

		return pageBean;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
