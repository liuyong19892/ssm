package com.raistudies.dao.jdbc;

import java.io.Serializable;
import java.util.List;

public interface IJdbcCommonDao {
	public <T> List<T> loadAll(String sql, Object[] object, final Class<T> entityClass);
	public <T> Serializable save(String sql, final T entity);
}
