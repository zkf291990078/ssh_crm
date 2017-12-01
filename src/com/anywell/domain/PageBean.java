package com.anywell.domain;

import java.util.List;

public class PageBean {
	private List list;
	private Integer currentPage;
	private Integer totalPage;
	private Integer totalCount;
	private Integer pageSize;

	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		if (currentPage == null) {
			this.currentPage = 1;
		}
		if (pageSize == null) {
			this.pageSize = 3;
		}
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
	}

	public Integer getstartIndex() {
		return (this.currentPage - 1) * pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
