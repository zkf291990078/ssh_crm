package com.anywell.service;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.domain.PageBean;
import com.anywell.domain.SaleVisit;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean getPageList(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	SaleVisit getById(String visit_id);

	void add(SaleVisit saleVisit);

}
