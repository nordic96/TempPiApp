package com.temppi.spring.model.dto;

public class SubMenuDTO {
	private long sub_id;
	private String sub_name;
	private String context;
	
	private MenuDTO menu;
	
	public long getSub_id() {
		return sub_id;
	}
	public void setSub_id(long sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public MenuDTO getMenu() {
		return menu;
	}
	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}
	
	@Override
	public String toString() {
		return "[" + sub_id + ", " + sub_name + ", "
	+ context + ", " + menu + "]";
	}
}
