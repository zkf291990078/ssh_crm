package com.anywell.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.domain.PageBean;
import com.anywell.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private Integer currentPage;
	private Integer pageSize;
	private CustomerService customerService;

	public String list() throws Exception {
		// TODO Auto-generated method stub

		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		PageBean pageBean = customerService.getCustomerList(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);

		return "toList";

	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
