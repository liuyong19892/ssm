package com.raistudies.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raistudies.dao.ICommonDao;
import com.raistudies.domain.User;
import com.raistudies.service.hibernate.RegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private ICommonDao hibernateCommonDao;
	
	public void saveUser(User user) {
		hibernateCommonDao.save(user);
	}

	public List<User> getAllUser() {
		return hibernateCommonDao.loadAll(User.class);
	}

	public void updateUser(User user) {
		hibernateCommonDao.saveOrUpdate(user);
	}

	public void deleteUser(String id) {
		
	}

}
