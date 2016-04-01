package com.raistudies.service.hibernate;

import java.util.List;

import com.raistudies.domain.User;

public interface RegistrationService {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String id);
	public List<User> getAllUser();
}
