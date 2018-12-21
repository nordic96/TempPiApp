package com.temppi.spring.model.dao;

import java.util.List;

import com.temppi.spring.model.dto.TempRecordDTO;

public interface TempRecordDAO {
	public List<TempRecordDTO> tempRecordList();
	public List<TempRecordDTO> getSearchResultList(String year, String month, String date);
	public List<Integer> getDateList();
	public List<Integer> getMonthList();
	public List<Integer> getYearList();
}
