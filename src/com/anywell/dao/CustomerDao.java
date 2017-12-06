package com.anywell.dao;

import java.util.List;

import com.anywell.domain.Customer;

public interface CustomerDao extends BaseDao<Customer> {

	List<Object[]> getIndustryCount();

}
