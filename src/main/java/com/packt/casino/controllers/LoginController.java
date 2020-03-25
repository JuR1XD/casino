package com.packt.casino.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController extends AbstractController
{

	/*	@RequestMapping(value="/login", method = RequestMethod.GET)
		public ModelAndView login(){
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login");
			return modelAndView;
		}*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model, @RequestParam(value = "error", required = false) String error,
			@Value("${casino.login.wrongUserCredentials}") String message,
			@Value("${casino.login.lockedAcc}") String newMessage, @Value("${casino.login.successfulLogout}") String message1,
			@RequestParam(value = "logout", required = false) String logout)
	{
		super.populateUser(model);

		ModelAndView mav = new ModelAndView();
		if(logout != null)
		{
			mav.addObject("logoutText", message1);
		}
		//Initially when you hit on login url then error and logout both null
		if (error != null)
		{
				mav.addObject("error", message);
		}
		mav.setViewName("login");

		return mav;

	}


}
