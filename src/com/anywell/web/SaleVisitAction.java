package com.anywell.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.domain.PageBean;
import com.anywell.domain.SaleVisit;
import com.anywell.domain.User;
import com.anywell.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	private SaleVisit saleVisit = new SaleVisit();
	private SaleVisitService saleVisitService;
	private Integer currentPage;
	private Integer pageSize;

	public String add() throws Exception {
		// TODO Auto-generated method stub
		// 0 取出登陆用户,放入SaleVisit实体.表达关系
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		// 1 调用Service保存客户拜访记录
		saleVisitService.save(saleVisit);

		return "toList";
	}

	public String list() throws Exception {
		// TODO Auto-generated method stub
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		// 判断并封装参数
		if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		PageBean pageBean = saleVisitService.getPageList(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	public String toEdit() throws Exception {
		// TODO Auto-generated method stub
		// 1调用Service根据id获得客户对象
		SaleVisit s = saleVisitService.getById(saleVisit.getVisit_id());
		// 2 将客户对象放置到request域,并转发到编辑页面
		ActionContext.getContext().put("saleVisit", s);
		return "edit";
	}


	@Override
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

}
