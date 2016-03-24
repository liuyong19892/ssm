package com.raistudies.service.mybatis;

import java.util.List;

import com.raistudies.domain.User;

public class Impl implements UserService{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveUser(User user) {
		System.out.println("a usersaved");
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
