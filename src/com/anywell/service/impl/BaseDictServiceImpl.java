package com.anywell.service.impl;

import java.util.List;

import com.anywell.dao.BaseDictDao;
import com.anywell.domain.BaseDict;
import com.anywell.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		List<BaseDict> list = baseDictDao.getListByTypeCode(dict_type_code);
		return list;
	}

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

}
