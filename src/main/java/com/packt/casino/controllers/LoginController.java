package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model, @RequestParam(value = "error", required = false) String error,
			@Value("${casino.login.wrongUserCredentials}") String message,
			@Value("${casino.login.lockedAcc}") String newMessage, @Value("${casino.login.successfulLogout}") String message1,
			@RequestParam(value = "logout", required = false) String logout, @RequestParam(value = "passwordChange", required = false) String changedPass,
			@RequestParam(value = "userChange", required = false) String changedUser, @Value("${casino.login.successfulLogout.changedPass}") String passwordMessage,
			@Value("${casino.login.successfulLogout.changedUser}") String userMessage)
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
		if(changedPass != null)
		{
			mav.addObject("changedUser", userMessage);
		}

		if(changedUser != null)
		{
			mav.addObject("changedPass", passwordMessage);
		}
		mav.setViewName("login");

		return mav;

	}


}
