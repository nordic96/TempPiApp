package com.temppi.spring.controller;


import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.MenuDAO;
import com.temppi.spring.model.dao.SubMenuDAO;
import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.model.dto.SubMenuDTO;

@Controller
public class SubMenuController {
	
	private static final Logger logger = Logger.getLogger(SubMenuController.class);
	
	@Autowired
	private SubMenuDAO subMenuDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping(value="/submenu", method = RequestMethod.GET)
	public ModelAndView subMenu() {
		ModelAndView model = new ModelAndView("template");
		model.addObject("content", "form_submenu");
		model.addObject("subMenuForm", new SubMenuDTO());
		
		List<SubMenuDTO> subMenuList = subMenuDAO.getAllSubMenu();
		List<MenuDTO> menuList = menuDAO.getAllMenuList();
		
		model.addObject("subMenuList", subMenuList);
		model.addObject("menuList", menuList);
		return model;
	}
	
	@RequestMapping(value="/submenu/add", method = RequestMethod.POST)
	public ModelAndView addSubMenu(@Valid @ModelAttribute SubMenuDTO subMenuForm) {
		boolean status = false;
		try {
			status = subMenuDAO.insertSubMenu(subMenuForm);
		} catch (Exception e ) {
			logger.error(e);
		}
		ModelAndView model = new ModelAndView("redirect:/submenu");
		model.addObject("insertResult", status);
		return model;
	}
}
