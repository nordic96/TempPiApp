package com.temppi.spring.model.dao;

import java.util.List;

import com.temppi.spring.model.dto.MenuDTO;

public interface MenuDAO {
	public List<MenuDTO> getAllMenuList();
	public boolean insertMenu(MenuDTO menu);
}
