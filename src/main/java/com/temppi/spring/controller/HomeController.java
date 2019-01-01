package com.temppi.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.TempRecordDAO;
import com.temppi.spring.model.dto.TempRecordDTO;

@Controller
public class HomeController {
	
	@Autowired
	private TempRecordDAO tempRecordDAO;
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home() {
		List<TempRecordDTO> tempRecordList = tempRecordDAO.tempRecordList();
		if(tempRecordList.isEmpty()) {
			logger.debug("tempRecordList is empty");
		}
		ModelAndView model = new ModelAndView("home");
		//model.addObject("tempRecordList", tempRecordList);
		return model;
	}
}
