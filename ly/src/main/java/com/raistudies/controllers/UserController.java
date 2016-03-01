package com.raistudies.controllers;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raistudies.domain.User;
import com.raistudies.persistence.UserService;

@Controller
@RequestMapping(value = "/registration")
public class UserController {
	@Resource
	private UserService userServiceForHibernate = null;

	@RequestMapping("/addUser")
	// 请求url地址映射，类似Struts的action-mapping
	public String addUser(User user) {

		userServiceForHibernate.saveUser(user);

		return "redirect:rest/registration/list";
	}

	@RequestMapping(path = "/list", method=RequestMethod.GET)
	public String getAllUser(ModelMap model) {
		List<User> users = userServiceForHibernate.getAllUser();
		model.addAttribute("users", users);
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		model.addAttribute("user", user);
		return "registration";
	}

}
