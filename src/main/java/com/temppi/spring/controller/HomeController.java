package com.temppi.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.MenuDAO;
import com.temppi.spring.model.dao.TempRecordDAO;
import com.temppi.spring.model.dto.MenuDTO;

@Controller
public class HomeController {
	
	@SuppressWarnings("unused")
	@Autowired
	private TempRecordDAO tempRecordDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.info("----home()----");
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	
	@RequestMapping(value="/menu_form", method = RequestMethod.GET)
	public ModelAndView menu_form() {
		ModelAndView model = new ModelAndView("template");
		List<MenuDTO> menuList = menuDAO.getAllMenuList();	
		model.addObject("addMenuForm", new MenuDTO());
		model.addObject("menuList", menuList);
		model.addObject("content", "form_menu");
		return model;
	}
}
