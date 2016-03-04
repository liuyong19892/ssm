package com.raistudies.service.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raistudies.dao.ICommonDao;
import com.raistudies.domain.User;
import com.raistudies.service.jdbc.JUserService;

@Service
public class JUserServiceImpl implements JUserService{
	@Autowired
	private ICommonDao jdbcCommonDao;
	
	@Override
	public List<User> getAllUser() {
		String sql = "SELECT id,name,standard,age,sex FROM db_user";
		return jdbcCommonDao.loadAll(sql, null, User.class);
	}

}
