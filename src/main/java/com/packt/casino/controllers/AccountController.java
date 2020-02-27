package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class AccountController
{
	@Autowired
	UserService userService;

	@RequestMapping("/account")
	public ModelAndView list(Model model)
	{
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		mav.addObject("userName", "Welcome " + user.getName() + " " + user.getSurname());
		mav.addObject("userNamePt2", "Name: " + user.getName() + " " + user.getSurname());
		mav.addObject("userEmail", "Email: " + user.getEmail());
		mav.addObject("userAddress", "Address: " + user.getStreet() + " " + user.getStreetNr());
		mav.addObject("userAddressPt2", "Postal Code: " + user.getPostalCode());
		mav.addObject("userAddressPt3", "City: " + user.getCity());
		mav.setViewName("account");

		return mav;
	}
}
