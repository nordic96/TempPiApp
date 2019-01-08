package com.temppi.spring.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.temppi.spring.util.JSONMapper;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuDTO {
	private long menu_id;
	private String menu_name;
	
	@JsonBackReference
	private List<SubMenuDTO> submenus;
	
	public long getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(long menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public List<SubMenuDTO> getSubmenus() {
		return submenus;
	}
	public void setSubmenus(List<SubMenuDTO> submenus) {
		this.submenus = submenus;
	}
	
	@Override
	public String toString() {
		return JSONMapper.mapJSONString(this);
	}
}
