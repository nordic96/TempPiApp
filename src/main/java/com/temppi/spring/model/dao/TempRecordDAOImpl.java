package com.temppi.spring.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import com.temppi.spring.model.dto.TempRecordDTO;

public class TempRecordDAOImpl implements TempRecordDAO{
	private SessionFactory sessionFactory;
	
	public TempRecordDAOImpl(SessionFactory sessionFactotry) {
		this.sessionFactory = sessionFactotry;
	}

	@Transactional
	@Override
	public List<TempRecordDTO> tempRecordList() {
		@SuppressWarnings("unchecked")
		List<TempRecordDTO> tempRecordList = 
				(List<TempRecordDTO>) sessionFactory.getCurrentSession()
				.createCriteria(TempRecordDTO.class)
				.list();
		return tempRecordList;
	}
}
