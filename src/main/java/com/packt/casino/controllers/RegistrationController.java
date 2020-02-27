package com.packt.casino.controllers;


import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransfer;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RegistrationController
{
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/signIn", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDataTransfer accountUser,
			BindingResult result, WebRequest request, Errors errors)
	{
		if (!accountUser.getPassword().equals(accountUser.getMatchingPassword()))
		{
			result.rejectValue("matchingPassword", "casino.signIn.passwordMatch.error");
		}
		/*if(!result.hasErrors())
		{

		}
		if(registered == null)
		{
			result.rejectValue("email", "casino.signIn.emailMatch.error");
		}
		{
				return new ModelAndView("signIn", "user", accountUser);
		}
		else*/
		if (!result.hasErrors())
		{
			createUserAccount(accountUser, result);
		}

		if (result.hasErrors())
		{
			return new ModelAndView("signIn", "user", accountUser);
		}

		return new ModelAndView("redirect:/success", "user", accountUser);

	}

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String showRegistrationForm(Model model, WebRequest request)
	{
		final UserDataTransfer user = new UserDataTransfer();
		model.addAttribute("user", new UserDataTransfer());
		return "signIn";
	}

	private User createUserAccount(UserDataTransfer account, BindingResult result)
	{
		User registered;

		try
		{
			registered = userService.registerNewUserAccount(account);
		}
		catch (EmailExistsException e)
		{
			result.rejectValue("email", "casino.signIn.emailMatch.error");
			return null;
		}
		return registered;
	}

	@RequestMapping("/success")
	public String success()
	{
		return "successfulSignIn";
	}


}
