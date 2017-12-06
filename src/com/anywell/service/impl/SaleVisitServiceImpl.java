package com.anywell.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.dao.SaleVisitDao;
import com.anywell.domain.PageBean;
import com.anywell.domain.SaleVisit;
import com.anywell.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao saleVisitDao;

	@Override
	public void save(SaleVisit saleVisit) {
		// TODO Auto-generated method stub
		saleVisitDao.saveOrUpdate(saleVisit);
	}

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	@Override
	public PageBean getPageList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);

		List<SaleVisit> list = saleVisitDao.getPageList(dc, pageBean.getstartIndex(), pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SaleVisit getById(String visit_id) {
		// TODO Auto-generated method stub
		return saleVisitDao.getById(visit_id);
	}

	@Override
	public void add(SaleVisit saleVisit) {
		// TODO Auto-generated method stub
		saleVisitDao.save(saleVisit);
	}

}
