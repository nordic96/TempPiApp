package com.temppi.spring.model.dao;

import java.util.List;

import com.temppi.spring.model.dto.SubMenuDTO;

public interface SubMenuDAO {
	public List<SubMenuDTO> getAllSubMenu();
	public boolean insertSubMenu(SubMenuDTO subMenu);
}
