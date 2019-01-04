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

import com.temppi.spring.model.dto.MenuDTO;

public class MenuDAOImpl implements MenuDAO{
	private static final Logger logger = Logger.getLogger(MenuDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public MenuDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<MenuDTO> getAllMenuList() {
		logger.info("----getAllMenuList()----");
		List<MenuDTO> menuList = new ArrayList<>();
		
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<MenuDTO> cq = cb.createQuery(MenuDTO.class);
		
		Root<MenuDTO> root = cq.from(MenuDTO.class);
		cq.select(root);
		
		Query<MenuDTO> q = sessionFactory.getCurrentSession().createQuery(cq);
		menuList = q.getResultList();
		return menuList;
	}

	@Transactional
	@Override
	public boolean insertMenu(MenuDTO menu) {
		logger.info("----insertMenu(" + menu.getMenu_name() + ")----");
		boolean status = false;

		try {
			sessionFactory
			.getCurrentSession()
			.save(menu);
			status = true;
		} catch (Exception e) {
			logger.error(e);
		}
		
		return status;
	}
}
