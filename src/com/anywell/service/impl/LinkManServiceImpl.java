package com.anywell.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.dao.LinkManDao;
import com.anywell.domain.LinkMan;
import com.anywell.domain.PageBean;
import com.anywell.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao;

	@Override
	public void save(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.saveOrUpdate(linkMan);
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
		List<LinkMan> list = linkManDao.getPageList(dc, pageBean.getstartIndex(), pageBean.getPageSize());
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		return linkManDao.getById(lkm_id);
	}

}
