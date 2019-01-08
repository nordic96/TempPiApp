package com.temppi.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.temppi.spring.model.dto.SubMenuDTO;
import com.temppi.spring.util.JSONMapper;

@Component
public class StringSubMenuConverter implements Converter<String, SubMenuDTO>{

	@Override
	public SubMenuDTO convert(String source) {
		// TODO Auto-generated method stub
		return JSONMapper.readJSONString(source, new SubMenuDTO());
	}

}
