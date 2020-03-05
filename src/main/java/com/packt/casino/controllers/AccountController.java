package com.packt.casino.controllers;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferEdit;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/account")
public class AccountController extends AbstractController
{
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserService userService;

	@RequestMapping
	public ModelAndView list(Model model)
	{
		super.populateUser(model);
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

	@RequestMapping(path = "/editUser", method = RequestMethod.POST)
	public ModelAndView updateUserAccount(Model model, @ModelAttribute("userEdit") @Valid UserDataTransferEdit accountUser,
			BindingResult result, WebRequest request, Errors errors)
	{

		if (!result.hasErrors())
		{
			editUserAccount(accountUser, result);
		}

		if (result.hasErrors())
		{
			return new ModelAndView("editUser", "userEdit", accountUser);
		}

		return new ModelAndView("redirect:/account", "userEdit", accountUser);

	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String showRegistrationForm(Model model, WebRequest request)
	{

		final UserDataTransferEdit user = new UserDataTransferEdit();
		model.addAttribute("userEdit", new UserDataTransferEdit());
		return "editUser";
	}

	private User editUserAccount(UserDataTransferEdit account, BindingResult result)
	{
		User registered;

		try
		{
			registered = userService.editUserAccount(account);
		}
		catch (EmailExistsException e)
		{
			result.rejectValue("email", "casino.signIn.emailMatch.error");
			return null;
		}
		return registered;
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
