package com.temppi.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.temppi.spring.model.dto.SubMenuDTO;

public class SubMenuDAOImpl implements SubMenuDAO{

	private static final Logger logger = Logger.getLogger(SubMenuDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public SubMenuDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<SubMenuDTO> getAllSubMenu() {
		logger.info("----getAllSubMenu()----");
		List<SubMenuDTO> subMenuList = new ArrayList<>();
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<SubMenuDTO> cq = cb.createQuery(SubMenuDTO.class);
		
		Root<SubMenuDTO> root = cq.from(SubMenuDTO.class);
		cq.select(root);
		
		Query<SubMenuDTO> q = sessionFactory.getCurrentSession().createQuery(cq);
		subMenuList = q.getResultList();
		
		for(SubMenuDTO sub : subMenuList) {
			logger.info("SubMenu: " + sub);
		}
		return subMenuList;
	}

	@Transactional
	@Override
	public boolean insertSubMenu(SubMenuDTO subMenu) {
		logger.info("----insertSubMenu(" + subMenu + ")----");
		boolean status = true;
		
		try {
			sessionFactory
			.getCurrentSession()
			.save(subMenu);
		} catch (Exception e) {
			status = false;
			logger.error(e);
		}
		
		return status;
	}

}
