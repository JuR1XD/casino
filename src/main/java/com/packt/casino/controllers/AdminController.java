package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.Authority;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController
{
	@Autowired
	UserService userService;

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ModelAndView displayAllUser(Model model)
	{
		super.populateUser(model);
		System.out.println("User Page Requested: All Users");
		ModelAndView mav = new ModelAndView();
		List userList = userService.getAllUsers();
		mav.addObject("userList", userList);
		mav.setViewName("adminUserList");
		return mav;
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView displayEditUserForm(@PathVariable Long id, Model model)
	{
		super.populateUser(model);
		ModelAndView mav = new ModelAndView("editUserAdmin");
		User user = userService.getUserById(id);
		mav.addObject("headerMessage", "Edit User Details");
		mav.addObject("userAdmin", user);
		return mav;
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedUser(@ModelAttribute User user, @ModelAttribute Authority authority,  BindingResult result, Model model)
	{
		super.populateUser(model);

		ModelAndView mav = new ModelAndView("redirect:/account");
		if(result.hasErrors())
		{
			System.out.println(result.toString());
			return new ModelAndView("editUserAdmin");
		}
		boolean isSaved = userService.saveUser(user);
		if(!isSaved)
		{
			return new ModelAndView("editUserAdmin");
		}
		return mav;
	}
}
