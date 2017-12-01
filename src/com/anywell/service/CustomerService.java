package com.anywell.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.domain.PageBean;

public interface CustomerService {

	PageBean getCustomerList(DetachedCriteria criteria, Integer currentPage, Integer pageSize);

}
