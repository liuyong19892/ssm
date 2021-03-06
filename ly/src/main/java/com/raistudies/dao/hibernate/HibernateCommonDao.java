package com.raistudies.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raistudies.dao.ICommonDao;
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository("hibernateCommonDao")
public class HibernateCommonDao implements ICommonDao{
	private static final Logger logger = Logger.getLogger(HibernateCommonDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.openSession();
	}
	
	public <T> void saveOrUpdate(T entity) {
		try {
			Session session = getSession();
//			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(entity);
			session.flush();
//			tx.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("添加或更新成功," + entity.getClass().getName());
			}
		} catch (RuntimeException e) {
			logger.error("添加或更新异常", e);
			throw e;
		}
	}
	
	public <T> Serializable save(T entity) {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = getSession().save(entity);
			transaction.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("保存实体成功," + entity.getClass().getName());
			}
			return id;
		} catch (RuntimeException e) {
			logger.error("保存实体异常", e);
			throw e;
		}

	}
	
	public <T> List<T> loadAll(final Class<T> entityClass) {
		Criteria criteria = createCriteria(entityClass);
		return criteria.list();
	}
	
	private <T> Criteria createCriteria(Class<T> entityClass) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria;
	}
	
	public <T> List<T> loadAll(String sql, Object[] object, Class<T> entityClass) {
		return null;
	}

	public <T> void delete(T entitie) {
		// TODO Auto-generated method stub
		
	}
}
