package com.raistudies.service.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raistudies.domain.User;
import com.raistudies.service.CommonService;
import com.raistudies.service.hibernate.RegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl extends CommonService implements RegistrationService {
	
	public void saveUser(User user) {
		System.out.println("111111111111111111111111111111111-----"+user);
		hibernateCommonDao.saveOrUpdate(user);
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
