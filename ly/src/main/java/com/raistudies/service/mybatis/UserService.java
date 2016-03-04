package com.raistudies.service.mybatis;

import java.util.List;

import com.raistudies.domain.User;

public interface UserService {
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String id);
	public List<User> getAllUser();
}
