package com.temppi.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.SearchByDateForm;
import com.temppi.spring.model.dao.TempRecordDAO;
import com.temppi.spring.model.dto.TempRecordDTO;

@Controller
public class SearchController {
	
	@Autowired
	private TempRecordDAO tempRecordDAO;
	
	private static final Logger logger = Logger.getLogger(SearchController.class);
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView search() {
		ModelAndView model = new ModelAndView("search");
		List<Integer> yearList = getYearList();
		
		model.addObject("yearList", yearList);
		model.addObject("searchForm", new SearchByDateForm());
		return model;
	}
	
	@RequestMapping(value="/search/{year_selected}", method = RequestMethod.GET)
	public @ResponseBody List<Integer> getMonths(@PathVariable("year_selected") String yearSelected) 
			throws IOException {
		List<Integer> monthList = getMonthList(yearSelected);
		return monthList;
	}
	
	@RequestMapping(value="/search/{year_selected}/{month_selected}", method = RequestMethod.GET)
	public @ResponseBody List<Integer> getDates(@PathVariable("year_selected") String yearSelected,
			@PathVariable("month_selected") String monthSelected) 
			throws IOException {
		List<Integer> monthList = getDateList(yearSelected, monthSelected);
		return monthList;
	}
	
	@RequestMapping(value="/searchResult", method = RequestMethod.POST)
	public ModelAndView searchResult(@Valid @ModelAttribute("searchForm") SearchByDateForm searchForm,
			BindingResult bindingResult) {
		logger.info("----searchResult()----");
		String year = searchForm.getSearch_year();
		String month = searchForm.getSearch_month();
		String date = searchForm.getSearch_date();
		logger.info("year: " + year);
		logger.info("month: " + month);
		logger.info("date: " + date);
		
		if(bindingResult.hasErrors()) {
			logger.debug("searchForm has error. returning back to /search");
			ModelAndView model = new ModelAndView("search");
			return model;
			
		} else {
			logger.debug("binding result does not have error.");
			ModelAndView model = new ModelAndView("searchResult");
			
			List<TempRecordDTO> searchResultList = 
					tempRecordDAO.getSearchResultList(year, month, date);
			model.addObject("searchResultList", searchResultList);
			model.addObject("year", year);
			model.addObject("month", month);
			model.addObject("date", date);
			String resultJson = JSONMapper.mapJSONString(searchResultList);
			//logger.info("JSON String value: " + resultJson);
			model.addObject("searchResultJson", resultJson);
			return model;				
		}
	}
	
	@ModelAttribute("yearList")
	public List<Integer> getYearList() {
		List<Integer> yearList = tempRecordDAO.getYearList();
		return yearList;
	}
	
	public List<Integer> getMonthList(String yearSelected) {
		List<Integer> monthList = tempRecordDAO.getMonthList(yearSelected);
		return monthList;
	}	
	
	public List<Integer> getDateList(String yearSelected, String monthSelected) {
		List<Integer> dateList = tempRecordDAO.getDateList(yearSelected, monthSelected);
		return dateList;
	}
}
