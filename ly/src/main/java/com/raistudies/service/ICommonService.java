package com.raistudies.service;

import java.io.Serializable;
import java.util.List;

public interface ICommonService {
	public <T> Serializable save(T entity);

	public <T> void saveOrUpdate(T entity);
	
	public <T> void delete(T entitie);
	
	public <T> List<T> loadAll(final Class<T> entityClass);

	public <T> List<T> loadAll(String sql, Object[] object, final Class<T> entityClass);
}
