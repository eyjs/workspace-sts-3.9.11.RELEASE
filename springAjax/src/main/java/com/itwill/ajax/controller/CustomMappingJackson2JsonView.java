package com.itwill.ajax.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class CustomMappingJackson2JsonView 
			extends MappingJackson2JsonView{
	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		Object result = super.filterModel(model);
		if(!(result instanceof Map)) {
			return result;
		}
		Map resultMap = (Map)result;
		if(resultMap.size()==1) {
			Collection c = resultMap.values();
			Object[] oa = c.toArray();
			return oa[0];
		}
		return super.filterModel(model);
	}
}
