package com.raistudies.controllers;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.raistudies.domain.CommonBean;
import com.raistudies.domain.User;
import com.raistudies.service.jdbc.JUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private JUserService jUserService = null;

	@RequestMapping("/add")
	// 请求url地址映射，类似Struts的action-mapping
	public String addUser(User user) {

		jUserService.saveUser(user);

		return "redirect:rest/user/list";
	}

	@RequestMapping(path = "/list", method=RequestMethod.GET)
	public String getAllUser(ModelMap model) {
		List<User> users = jUserService.getAllUser();
		model.addAttribute("users", users);
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		model.addAttribute("user", user);
		return "registration";
	}

	@RequestMapping(path = "/list/gson", method=RequestMethod.GET)
	public void returnGson(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws Exception{
		String callBack = request.getParameter("callback");
		List<User> users = jUserService.getAllUser();
		CommonBean outBean = new CommonBean();
		outBean.setCacheStart(0);
		outBean.setCount(users.size());
		outBean.setResults(users);
		Gson gson = new Gson();
		System.out.println("json output : " + gson.toJson(outBean));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(callBack + "(" + gson.toJson(outBean) + ")");
		response.getWriter().flush();
	}
	
	
	
	
	
}
