package com.temppi.spring.controller;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {
	private static final Logger logger = Logger.getLogger(JSONMapper.class);
	
	public static String mapJSONString(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error(e);
		}
		return jsonString;
	}
}
