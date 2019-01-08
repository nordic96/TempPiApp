package com.temppi.spring.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.editor.MenuEditor;
import com.temppi.spring.model.dao.SubMenuDAO;
import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.model.dto.SubMenuDTO;

/**
 * Spring controller for SubMenu contents.
 * @author Ko Gi Hun
 *
 */
@Controller
public class SubMenuController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(MenuDTO.class, new MenuEditor());
	}
	
	private static final Logger logger = Logger.getLogger(SubMenuController.class);
	
	@Autowired
	private SubMenuDAO subMenuDAO;
	
	/**
	 * 
	 * @param subMenuForm form submitted from the client side.
	 * @return model redirecting /submenu.
	 */
	@RequestMapping(value="/submenu/add", method = RequestMethod.POST)
	public ModelAndView addSubMenu(@Valid @ModelAttribute SubMenuDTO subMenuForm) {
		logger.debug("--------------------addSubMenu()--------------------");
		boolean status = false;
		logger.debug("SUBMENU: Menu ID : " + subMenuForm.getMenu().getMenu_id());
		logger.debug("SUBMENU: Menu NAME : " + subMenuForm.getMenu().getMenu_name());
		
		status = subMenuDAO.insertSubMenu(subMenuForm);
		
		ModelAndView model = new ModelAndView("redirect:/submenu");
		model.addObject("insertResult", status);
		logger.debug("--------------------addSubMenu()--------------------");
		return model;
	}
}
