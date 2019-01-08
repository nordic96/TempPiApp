package com.temppi.spring.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * JSON Mapper using Jackson library to map & read objects.
 * @author Ko Gi Hun
 *
 */
public class JSONMapper {
	private static final Logger logger = Logger.getLogger(JSONMapper.class);
	
	public static String mapJSONString(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error(e);
		}
		return jsonString;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readJSONString(String json, T t) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		try {
			logger.info("------------------readJSONString(" + json + ")------------------");
			t = (T) mapper.readValue(json, t.getClass());
			logger.info("------------------readJSONString()------------------");
		} catch (JsonGenerationException e1) {
			logger.error(e1);
			e1.printStackTrace();
		} catch (JsonMappingException e2) {
			logger.error(e2);
			e2.printStackTrace();
		} catch (IOException e3) {
			logger.error(e3);
			e3.printStackTrace();
		}
		return t;
	}
}
