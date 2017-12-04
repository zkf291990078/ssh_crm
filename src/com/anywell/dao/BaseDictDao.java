package com.anywell.dao;

import java.util.List;

import com.anywell.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);
}
