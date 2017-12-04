package com.anywell.service;

import java.util.List;

import com.anywell.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);
}
