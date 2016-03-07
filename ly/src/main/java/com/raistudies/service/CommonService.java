package com.raistudies.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.raistudies.dao.ICommonDao;

@Transactional
public class CommonService implements ICommonService{
	@Autowired
	public ICommonDao hibernateCommonDao = null;

	@Override
	public <T> Serializable save(T entity) {
		// TODO Auto-generated method stub
		return hibernateCommonDao.save(entity);
	}

	@Override
	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void delete(T entitie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> loadAll(String sql, Object[] object, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return hibernateCommonDao.loadAll(sql, object, entityClass);
	}
	
	
	
	
	
	
}
