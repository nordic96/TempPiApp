package com.temppi.spring.model.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
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
		logger.info("---tempRecordList()---");
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
	public List<Integer> getDateList(String yearSelected, String monthSelected) {
		logger.info("---getDateList("+yearSelected + "," + monthSelected + ")---");
		CriteriaBuilder cb = sessionFactory
				.getCurrentSession()
				.getCriteriaBuilder();
		
		CriteriaQuery<Integer> criteria = cb
				.createQuery(Integer.class);
		
		Root<TempRecordDTO> root = criteria.from(TempRecordDTO.class);
		
		criteria.select(root.get("rec_date"))
		.where(
				cb.equal(root.get("rec_year"), yearSelected),
				cb.equal(root.get("rec_month"), monthSelected)
				)
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
	public List<Integer> getMonthList(String yearSelected) {
		logger.info("---getMonthList(" + yearSelected + ")---");
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaQuery<Integer> cq = cb
				.createQuery(Integer.class);
		
		Root<TempRecordDTO> root = cq.from(TempRecordDTO.class);
		
		cq.select(root.get("rec_month"))
		.where(
				cb.equal(root.get("rec_year"), yearSelected)
				)
		.distinct(true);
		Query<Integer> q = sessionFactory.getCurrentSession().createQuery(cq);
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

	@Transactional
	@Override
	public List<TempRecordDTO> getSearchResultList(String year, String month, String date) {
		logger.info("---getSearchResultList(" + year + ", " + month + ", " + date + ")---");
		CriteriaBuilder cb = sessionFactory
				.getCurrentSession()
				.getCriteriaBuilder();
		
		CriteriaQuery<TempRecordDTO> criteria = cb
				.createQuery(TempRecordDTO.class);
		
		Root<TempRecordDTO> root = criteria.from(TempRecordDTO.class);
		criteria.select(root)
		.where(
				cb.equal(root.get("rec_year"), year),
				cb.equal(root.get("rec_month"), month),
				cb.equal(root.get("rec_date"), date)
				);
		
		Query<TempRecordDTO> q = sessionFactory.getCurrentSession().createQuery(criteria);
		List<TempRecordDTO> searchResultList = q.getResultList();
		return searchResultList;
	}
}
