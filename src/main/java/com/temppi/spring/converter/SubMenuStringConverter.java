package com.temppi.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.temppi.spring.model.dto.SubMenuDTO;
import com.temppi.spring.util.JSONMapper;

@Component
public class SubMenuStringConverter implements Converter<SubMenuDTO, String>{

	@Override
	public String convert(SubMenuDTO source) {
		return JSONMapper.mapJSONString(source);
	}
	
}
