package com.raistudies.persistence.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.raistudies.domain.User;
import com.raistudies.persistence.UserService;

public class UserServiceImpl implements UserService{
	 @Autowired
	private SessionFactory sessionFactory;  
     
	    public void setSessionFactory(SessionFactory sessionFactory) {  
	        this.sessionFactory = sessionFactory;  
	    }

		@Override
		public void saveUser(User user) {
			// TODO Auto-generated method stub
			sessionFactory.openSession().save(user);
		}

		@Override
		public void updateUser(User user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteUser(String id) {
			// TODO Auto-generated method stub
			
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<User> getAllUser() {
			// TODO Auto-generated method stub
			 String hql = "from User";  
		        Query query = sessionFactory.openSession().createQuery(hql);  
		        return query.list(); 
		}  
}
