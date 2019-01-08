package com.temppi.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temppi.spring.editor.MenuEditor;
import com.temppi.spring.model.dao.SubMenuDAO;
import com.temppi.spring.model.dao.TempRecordDAO;
import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.model.dto.SubMenuDTO;
import com.temppi.spring.util.JSONMapper;
import com.temppi.spring.util.ModelInitialiser;

@Controller
public class HomeController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(MenuDTO.class, new MenuEditor());
	}
	
	@SuppressWarnings("unused")
	@Autowired
	private TempRecordDAO tempRecordDAO;
	
	@Autowired
	private ModelInitialiser modelInitialiser;
	
	@Autowired
	private SubMenuDAO subMenuDAO;	
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.info("----home()----");
		ModelAndView model = modelInitialiser.modelInit("home");
		return model;
	}
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public ModelAndView menu_form() {
		ModelAndView model = modelInitialiser.modelInit("form_menu");
		model.addObject("addMenuForm", new MenuDTO());
		return model;
	}
	
	@RequestMapping(value="/submenu", method = RequestMethod.GET)
	public ModelAndView subMenu() {
		
		ModelAndView model = modelInitialiser.modelInit("form_submenu");
		model.addObject("subMenuForm", new SubMenuDTO());
		List<SubMenuDTO> subMenuList = subMenuDAO.getAllSubMenu();
		for (SubMenuDTO sub : subMenuList) {
			logger.debug("HOME CONTROLLER : SUB: " + sub);
		}
		String subMenuJson = JSONMapper.mapJSONString(subMenuList);
		
		logger.info("JSON String: " + subMenuJson);
		
		model.addObject("subMenuListJson", subMenuJson);
		return model;
	}
}
