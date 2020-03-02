package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class AbstractController
{

	@Autowired
	UserService userService;


	public void populateUser(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if(auth.getName() != null && user != null)
		{
			model.addAttribute("user", user.getName() + " " + user.getSurname());
		}
	}
}
