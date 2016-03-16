package com.raistudies.dao.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.raistudies.utils.MyBeanUtils;
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
	
	public <T> List<T> loadAll(String sql, Object[] object,Class<T> clazz) {
		List<T> rsList = new ArrayList<T>();
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		T po = null;
		for(Map<String,Object> m:mapList){
			try {
				po = clazz.newInstance();
				MyBeanUtils.copyMap2Bean_Nobig(po, m);
				rsList.add(po);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rsList;
	}

	
}
