package com.raistudies.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raistudies.domain.User;
import com.raistudies.service.hibernate.RegistrationService;
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
//        System.out.println(userService.getAllUser());
        User user = new User();
//        user.setId("42a8b64a-8731-4721-b276-3cd021caf5c6");
        user.setAge("11");
        user.setName("22");
        user.setSex("ffffemale");
        user.setStandard("high");
        registrationService.saveUser(user);
//        System.out.println(registrationService.getAllUser());
        
//        System.out.println(jUserService.getAllUser());
    }
 
}
