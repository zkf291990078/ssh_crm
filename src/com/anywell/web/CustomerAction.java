package com.anywell.web;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.domain.PageBean;
import com.anywell.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private Integer currentPage;
	private Integer pageSize;
	private CustomerService customerService;

	// 上传的文件会自动封装到File对象
	// 在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	// 在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	// 在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中
	private String photoContentType;

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

		return "list";

	}

	public String add() throws Exception {
		// TODO Auto-generated method stub
		if (photo != null) {
			System.out.println("文件名称:" + photoFileName);
			System.out.println("文件类型:" + photoContentType);
			// 将上传文件保存到指定位置
			photo.renameTo(new File("E:/upload/haha.jpg"));
		}

		// ---------------------------------------------------------------------
		// 1 调用Service,保存Customer对象
		customerService.save(customer);
		// 2 重定向到客户列表Action
		return "toList";
	}

	public String toEdit() throws Exception {
		// TODO Auto-generated method stub
		// 1调用Service根据id获得客户对象
		Customer c = customerService.getById(customer.getCust_id());
		// 2 将客户对象放置到request域,并转发到编辑页面
		ActionContext.getContext().put("customer", c);
		return "edit";
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

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

}
