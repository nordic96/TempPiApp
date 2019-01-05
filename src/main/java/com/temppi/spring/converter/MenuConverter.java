package com.temppi.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.temppi.spring.controller.JSONMapper;
import com.temppi.spring.model.dto.MenuDTO;

@Component
public class MenuConverter implements Converter<String, MenuDTO>{

	@Override
	public MenuDTO convert(String source) {
		return JSONMapper.readJSONString(source, new MenuDTO());
	}
}
