package com.anywell.web;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.domain.LinkMan;
import com.anywell.domain.PageBean;
import com.anywell.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	private LinkManService linkManService;
	private Integer currentPage;
	private Integer pageSize;

	public String add() throws Exception {
		// TODO Auto-generated method stub
		linkManService.save(linkMan);

		return "toList";
	}

	public String list() throws Exception {
		// TODO Auto-generated method stub

		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if (linkMan.getCustomer() != null && linkMan.getCustomer().getCust_id() != null) {
			dc.add(Restrictions.like("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		PageBean pageBean = linkManService.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);

		return "list";
	}

	public String toEdit() throws Exception {
		// TODO Auto-generated method stub
		// 1调用Service根据id获得客户对象
		LinkMan l = linkManService.getById(linkMan.getLkm_id());
		// 2 将客户对象放置到request域,并转发到编辑页面
		ActionContext.getContext().put("linkMan", l);
		return "edit";
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
