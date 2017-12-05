package com.anywell.service;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.domain.LinkMan;
import com.anywell.domain.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	LinkMan getById(Long lkm_id);



}
