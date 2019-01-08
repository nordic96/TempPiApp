package com.temppi.spring.editor;

import java.beans.PropertyEditorSupport;

import org.apache.log4j.Logger;

import com.temppi.spring.model.dto.MenuDTO;
import com.temppi.spring.util.JSONMapper;

public class MenuEditor extends PropertyEditorSupport{
	
	private static final Logger logger = Logger.getLogger(MenuEditor.class);
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.info("----setAsText(" + text + ")----");
		MenuDTO menu = (MenuDTO) JSONMapper.readJSONString(text, new MenuDTO());
		logger.debug("MENU ID: " + menu.getMenu_id());
		logger.debug("MENU NAME: " + menu.getMenu_name());
		setValue(menu);
	}
	
	@Override
	public String getAsText() {
		MenuDTO menu = (MenuDTO) getValue();
		return JSONMapper.mapJSONString(menu);
	}
}
