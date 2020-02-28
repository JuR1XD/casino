package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/account")
public class AccountController
{
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserService userService;

	@RequestMapping
	public ModelAndView list(Model model)
	{
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		mav.addObject("userName", user.getName() + " " + user.getSurname());
		mav.addObject("userNamePt2", user.getName() + " " + user.getSurname());
		mav.addObject("userEmail", user.getEmail());
		mav.addObject("userAddress", user.getStreet() + " " + user.getStreetNr());
		mav.addObject("userAddressPt2", user.getPostalCode());
		mav.addObject("userAddressPt3", user.getCity());
		mav.addObject("currentMoney", user.getCredit());
		mav.setViewName("account");

		return mav;
	}

	@RequestMapping(value = "/editUser")
	public String edit(Model model)
	{
		return "editUser";
	}

	@RequestMapping(value = "/editPassword")
	public String editPassword(Model model)
	{
		return "editPassword";
	}

	public void update(User user)
	{
		jdbcTemplate.update(
				"UPDATE current_user SET name=?, surname=?, street=?, streetNr=?, postalCode=?, city=? WHERE identity=?", user.getName(), user.getSurname(), user.getStreet(), user.getStreetNr(), user.getPostalCode(), user.getCity(), user.getUserId()
		);
	}
}
