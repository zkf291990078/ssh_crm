package com.anywell.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.anywell.domain.BaseDict;
import com.anywell.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {

	private BaseDictService baseDictService;
	private String dict_type_code;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<BaseDict> list= baseDictService.getListByTypeCode(dict_type_code);
	    String json=JSONArray.fromObject(list).toString();
		
	   ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	   ServletActionContext.getResponse().getWriter().write(json);
	  
		return null;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	
	
}
