package com.packt.casino.controllers;


import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistrationController
{
@Autowired
	public UserService userService;

@RequestMapping(value = "/signIn", method = RequestMethod.GET)
public String signIn(Model model, @ModelAttribute("newUser")
		BindingResult result, HttpServletRequest request)
{
	User addUser = new User();
	model.addAttribute("signIn", addUser);
	return "signIn";

}

/*@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user)
{

}*/
}
