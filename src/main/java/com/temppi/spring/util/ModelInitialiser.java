package com.temppi.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.model.dao.MenuDAO;
import com.temppi.spring.model.dao.SubMenuDAO;

/**
 * 
 * <p>Initialises default model and view by adding menu list and 
 * submenu list objects with a template jsp view.</p>
 * @author Ko Gi Hun
 *
 */
public class ModelInitialiser {
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private SubMenuDAO subMenuDAO;
	
	public ModelAndView modelInit() {
		ModelAndView model = new ModelAndView("template");
		model.addObject("menuList", menuDAO.getAllMenuList());
		model.addObject("subMenuList", subMenuDAO.getAllSubMenu());
		
		return model;
	}
	
	public ModelAndView modelInit(String content) {
		ModelAndView model = new ModelAndView("template");
		model.addObject("menuList", menuDAO.getAllMenuList());
		model.addObject("subMenuList", subMenuDAO.getAllSubMenu());
		
		model.addObject("content", content);
		
		return model;
	}
}
