package com.temppi.spring.model.dao;

import java.util.List;

import com.temppi.spring.model.dto.TempRecordDTO;

public interface TempRecordDAO {
	public List<TempRecordDTO> tempRecordList();
	public List<TempRecordDTO> getSearchResultList(String year, String month, String date);
	public List<Integer> getDateList(String yearSelected, String monthSelected);
	public List<Integer> getMonthList(String yearSelected);
	public List<Integer> getYearList();
}
