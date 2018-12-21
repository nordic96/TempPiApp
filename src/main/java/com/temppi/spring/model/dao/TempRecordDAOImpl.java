package com.temppi.spring.model.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.temppi.spring.model.dto.TempRecordDTO;

public class TempRecordDAOImpl implements TempRecordDAO{
	private static final Logger logger = Logger.getLogger(TempRecordDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public TempRecordDAOImpl(SessionFactory sessionFactotry) {
		this.sessionFactory = sessionFactotry;
	}

	@Transactional
	@Override
	public List<TempRecordDTO> tempRecordList() {
		CriteriaQuery<TempRecordDTO> cq = sessionFactory.getCurrentSession()
				.getCriteriaBuilder()
				.createQuery(TempRecordDTO.class);
		cq.from(TempRecordDTO.class);
		List<TempRecordDTO> tempRecordList = sessionFactory.getCurrentSession()
				.createQuery(cq)
				.getResultList();
		return tempRecordList;
	}

	@Transactional
	@Override
	public List<Integer> getDateList() {
		logger.info("---getDateList()---");
		CriteriaQuery<Integer> criteria = sessionFactory.getCurrentSession()
				.getCriteriaBuilder()
				.createQuery(Integer.class);
		Root<TempRecordDTO> root = criteria.from(TempRecordDTO.class);
		criteria.select(root.get("rec_date"))
		.distinct(true);
		Query<Integer> q = sessionFactory.getCurrentSession().createQuery(criteria);
		List<Integer> dateList = q.getResultList();
		for(int date: dateList) {
			logger.info("selected date:" + date);
		}
		return dateList;
	}

	@Transactional
	@Override
	public List<Integer> getMonthList() {
		logger.info("---getMonthList()---");
		CriteriaQuery<Integer> criteria = sessionFactory.getCurrentSession()
				.getCriteriaBuilder()
				.createQuery(Integer.class);
		Root<TempRecordDTO> root = criteria.from(TempRecordDTO.class);
		criteria.select(root.get("rec_month"))
		.distinct(true);
		Query<Integer> q = sessionFactory.getCurrentSession().createQuery(criteria);
		List<Integer> monthList = q.getResultList();
		for(int month: monthList) {
			logger.info("selected month:" + month);
		}
		return monthList;
	}

	@Transactional
	@Override
	public List<Integer> getYearList() {
		logger.info("---getYearList()---");
		CriteriaQuery<Integer> criteria = sessionFactory.getCurrentSession()
				.getCriteriaBuilder()
				.createQuery(Integer.class);
		Root<TempRecordDTO> root = criteria.from(TempRecordDTO.class);
		criteria.select(root.get("rec_year"))
		.distinct(true);
		Query<Integer> q = sessionFactory.getCurrentSession().createQuery(criteria);
		List<Integer> yearList = q.getResultList();
		for(int year: yearList) {
			logger.info("selected year:" + year);
		}
		return yearList;
	}
}
