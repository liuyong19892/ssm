package com.raistudies.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raistudies.service.hibernate.registration.RegistrationService;
import com.raistudies.service.jdbc.JUserService;
import com.raistudies.service.mybatis.UserService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/app-config.xml")
public class UserServiceTest {
     
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private JUserService jUserService;
     
    @Test
    public void testLoadAlll(){
        System.out.println(userService.getAllUser());
        
        System.out.println(registrationService.getAllUser());
        
        System.out.println(jUserService.getAllUser());
    }
 
}
