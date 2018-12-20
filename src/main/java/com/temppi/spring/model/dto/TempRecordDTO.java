package com.temppi.spring.model.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TempRecordDTO {
	private long id;
	private int rec_year;
	private int rec_month;
	private int rec_date;
	@Temporal(TemporalType.TIME)
	private Date rec_time;
	private float temp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRec_year() {
		return rec_year;
	}
	public void setRec_year(int rec_year) {
		this.rec_year = rec_year;
	}
	public int getRec_month() {
		return rec_month;
	}
	public void setRec_month(int rec_month) {
		this.rec_month = rec_month;
	}
	public int getRec_date() {
		return rec_date;
	}
	public void setRec_date(int rec_date) {
		this.rec_date = rec_date;
	}
	public Date getRec_time() {
		return rec_time;
	}
	public void setRec_time(Date rec_time) {
		this.rec_time = rec_time;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
}
