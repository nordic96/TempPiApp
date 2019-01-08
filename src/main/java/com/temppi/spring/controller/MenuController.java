package com.temppi.spring.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.MenuDAO;
import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.util.ModelInitialiser;

@Controller
public class MenuController {
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private ModelInitialiser modelInitialiser;
	
	private static final Logger logger = Logger.getLogger(MenuController.class);
	
	@RequestMapping(value="/addMenu", method = RequestMethod.POST)
	public ModelAndView addMenu(@Valid @ModelAttribute("addMenuForm") MenuDTO menu,
			BindingResult result) {
		logger.info("----addMenu()----");
		ModelAndView model = modelInitialiser.modelInit("form_menu");
		
		if (result.hasErrors()) {
			logger.error("validation error.");
		} else {
			boolean status = menuDAO.insertMenu(menu);
			model.addObject("successMsg", status);
		}
		return new ModelAndView("redirect:/menu");
	}
}
