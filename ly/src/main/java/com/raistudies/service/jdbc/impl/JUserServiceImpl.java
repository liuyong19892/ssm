package com.raistudies.service.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raistudies.dao.jdbc.IJdbcCommonDao;
import com.raistudies.domain.User;
import com.raistudies.service.jdbc.JUserService;

@Service("jUserService")
public class JUserServiceImpl implements JUserService{
	
	@Autowired
	public IJdbcCommonDao jdbcCommonDao = null;
	
	@Override
	public List<User> getAllUser() {
		String sql = "SELECT * FROM db_user";
		return jdbcCommonDao.loadAll(sql, null, User.class);
	}
	
	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO db_user (id,name,standard,age,sex) VALUES (:id,:name,:standard,:age,:sex)";
		jdbcCommonDao.save(sql, user.getClass());		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}
}
