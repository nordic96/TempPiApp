package com.temppi.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchByDateForm {
	@NotNull(message="is required")
	@Pattern(regexp = "^[0-9]*$", message="please choose year")
	private String search_year;
	
	@NotNull(message="is required")
	@Pattern(regexp = "^[0-9]*$", message="please choose month")
	private String search_month;
	
	@NotNull(message="is required")
	@Pattern(regexp = "^[0-9]*$", message="please choose a date")
	private String search_date;

	public String getSearch_year() {
		return search_year;
	}

	public void setSearch_year(String search_year) {
		this.search_year = search_year;
	}

	public String getSearch_month() {
		return search_month;
	}

	public void setSearch_month(String search_month) {
		this.search_month = search_month;
	}

	public String getSearch_date() {
		return search_date;
	}

	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}
	
	
}
