package com.raistudies.dao.jdbc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository("jdbcCommonDao")
public class JdbcCommonDao implements IJdbcCommonDao{
	
	private static final Logger logger = Logger.getLogger(JdbcCommonDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public<T> Serializable save(String sql, final T entity) {
		try {
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(entity);
			Serializable result =namedParameterJdbcTemplate.update(sql, namedParameters);
			if (logger.isDebugEnabled()) {
				logger.debug("更新成功," + sql + "\n " + entity.toString());
			}
			return result;
		} catch (RuntimeException e) {
			logger.error("更新异常", e);
			throw e;
		}
	}
	
	public <T> List<T> loadAll(String sql, Object[] params, final Class<T> entityClass) {
		return  jdbcTemplate.queryForList(sql, params, entityClass);
	}

	
}
