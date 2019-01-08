package com.temppi.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.util.JSONMapper;

@Component
public class MenuStringConverter implements Converter<MenuDTO, String>{

	@Override
	public String convert(MenuDTO source) {
		return JSONMapper.mapJSONString(source);
	}
	
}
