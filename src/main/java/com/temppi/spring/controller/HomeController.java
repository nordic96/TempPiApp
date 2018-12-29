package com.temppi.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.TempRecordDAO;
import com.temppi.spring.model.dto.TempRecordDTO;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private TempRecordDAO tempRecordDAO;
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		List<TempRecordDTO> tempRecordList = tempRecordDAO.tempRecordList();
		if(tempRecordList.isEmpty()) {
			logger.debug("tempRecordList is empty");
		}
		ModelAndView model = new ModelAndView("home");
		model.addObject("tempRecordList", tempRecordList);
		return model;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView searchByDate(@RequestParam("search_year") String year, 
			@RequestParam("search_month") String month, 
			@RequestParam("search_date") String date) {
		ModelAndView model = new ModelAndView("search");
		List<TempRecordDTO> searchResultList = 
				tempRecordDAO.getSearchResultList(year, month, date);
		model.addObject("searchResultList", searchResultList);
		
		String resultJson = JSONMapper.mapJSONString(searchResultList);
		logger.info("JSON String value: " + resultJson);
		model.addObject("searchResultJson", resultJson);
		return model;	
	}
	
	@ModelAttribute("yearList")
	public List<Integer> getYearList() {
		List<Integer> yearList = tempRecordDAO.getYearList();
		return yearList;
	}
	
	@ModelAttribute("monthList")
	public List<Integer> getMonthList() {
		List<Integer> monthList = tempRecordDAO.getMonthList();
		return monthList;
	}	
	
	@ModelAttribute("dateList")
	public List<Integer> getDateList() {
		List<Integer> dateList = tempRecordDAO.getDateList();
		return dateList;
	}
}
