package com.raistudies.controllers;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raistudies.domain.User;
import com.raistudies.service.hibernate.RegistrationService;
import com.raistudies.validator.RegistrationValidator;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	@Resource       //@Autowired按byType自动注入，而@Resource默认按 byName自动注入
	private RegistrationValidator validator = null;
	@Autowired
	private RegistrationService registrationService = null;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<User> users = registrationService.getAllUser();
		model.addAttribute("users", users);
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		model.addAttribute("user", user);
		return "registration";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			registrationService.saveUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", registrationService.getAllUser());
		return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			registrationService.updateUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", registrationService.getAllUser());
		return mv;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			registrationService.deleteUser(user.getId());
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", registrationService.getAllUser());
		return mv;
	}
}
