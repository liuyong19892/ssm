package com.raistudies.dao.jdbc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raistudies.dao.ICommonDao;
@Repository("jdbcCommonDao")
public class JdbcCommonDao implements ICommonDao{
	
	private static final Logger logger = Logger.getLogger(JdbcCommonDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public <T> Serializable save(String sql, Object[] params) {
		try {
			int result = jdbcTemplate.update(sql, params);
			if (logger.isDebugEnabled()) {
				logger.debug("更新成功," + sql + "\n " + params);
			}
			return result;
		} catch (RuntimeException e) {
			logger.error("更新异常", e);
			throw e;
		}

	}

	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	public <T> void delete(T entitie) {
		// TODO Auto-generated method stub
		
	}
	
	public <T> List<T> loadAll(String sql, Object[] params, final Class<T> entityClass) {
		return  jdbcTemplate.queryForList(sql, params, entityClass);
	}

	public <T> Serializable save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> loadAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
