package com.packt.casino.controllers;

import com.packt.casino.Service.MailService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferEdit;
import com.packt.casino.domain.UserDataTransferEditCredit;
import com.packt.casino.domain.UserDataTransferEditPw;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/account")
public class AccountController extends AbstractController
{
	@Autowired
	UserService userService;

	@Autowired
	MailService mailService;

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
	public ModelAndView updateUserAccount(Model model,
			@ModelAttribute("userEdit") @Valid UserDataTransferEdit accountUser, BindingResult result,
			WebRequest request, Errors errors)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		super.populateUser(model);

		if (!result.hasErrors())
		{
			editUserAccount(accountUser, result);
		}

		if (result.hasErrors())
		{
			return new ModelAndView("editUser", "userEdit", accountUser);
		}

		if (accountUser.getEmail().contains(user.getEmail()))
		{
			return new ModelAndView("redirect:/account", "userEdit", accountUser);
		}
		else
		{
			return new ModelAndView("redirect:/logout", "userEdit", accountUser);
		}
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String showEditForm(Model model, WebRequest request)
	{
		super.populateUser(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userService.findUserByEmail(auth.getName());
		final UserDataTransferEdit user = new UserDataTransferEdit();
		model.addAttribute("userGet", user1);
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

	@RequestMapping(value = "/editPassword", method = RequestMethod.GET)
	public String updatePassword(Model model, WebRequest request,
			@ModelAttribute("passwordEdit") @Valid UserDataTransferEditPw userDataTransferEditPW,
			BindingResult result, Errors errors,
			@RequestParam(value = "error", required = false) String error)
	{
		super.populateUser(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userService.findUserByEmail(auth.getName());
		final UserDataTransferEdit user = new UserDataTransferEdit();
		model.addAttribute("userGet", user1);
		model.addAttribute("passwordEdit", new UserDataTransferEditPw());

		return "editPassword";
	}

	@RequestMapping(path = "/editPassword", method = RequestMethod.POST)
	public ModelAndView updateUserAccountPassword(Model model,
			@ModelAttribute("passwordEdit") @Valid UserDataTransferEditPw accountUser, BindingResult result,
			WebRequest request, Errors errors)
	{
		super.populateUser(model);

		if (!result.hasErrors())
		{
			editUserAccountPassword(accountUser, result);
		}

		if (result.hasErrors())
		{
			return new ModelAndView("editPassword", "passwordEdit", accountUser);
		}

		return new ModelAndView("redirect:/logout", "passwordEdit", accountUser);
	}

	private User editUserAccountPassword(UserDataTransferEditPw account, BindingResult result)
	{
		User registered;

		try
		{
			registered = userService.editPassword(account);
		}
		catch (Exception e)
		{
			result.rejectValue("password", "Password is not correct");
			return null;
		}
		return registered;
	}

	@RequestMapping(path = "/addCredit", method = RequestMethod.POST)
	public ModelAndView updateUserCredit(Model model,
			@ModelAttribute("userCredit") @Valid UserDataTransferEditCredit accountUser, BindingResult result,
			WebRequest request, Errors errors)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		super.populateUser(model);

		if (!result.hasErrors())
		{
			editUserCredit(accountUser, result);
			mailService.sendMail();
		}

		if (result.hasErrors())
		{
			return new ModelAndView("addCredit", "userCredit", accountUser);
		}
			return new ModelAndView("redirect:/account", "userCredit", accountUser);
	}

	@RequestMapping(value = "/addCredit", method = RequestMethod.GET)
	public String showCreditForm(Model model, WebRequest request)
	{
		super.populateUser(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userService.findUserByEmail(auth.getName());
		final UserDataTransferEdit user = new UserDataTransferEdit();
		model.addAttribute("userGet", user1);
		model.addAttribute("userCredit", new UserDataTransferEditCredit());
		return "addCredit";
	}

	private User editUserCredit(UserDataTransferEditCredit account, BindingResult result)
	{
		User registered;

		try
		{
			registered = userService.addCredit(account);
		}
		catch (Exception e)
		{
			result.rejectValue("credit", "casino.edit.notNull.credit");
			return null;
		}
		return registered;
	}@RequestMapping(path = "/withCredit", method = RequestMethod.POST)
	public ModelAndView updateUserCreditWith(Model model,
			@ModelAttribute("userWithCredit") @Valid UserDataTransferEditCredit accountUser, BindingResult result,
			WebRequest request, Errors errors)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		super.populateUser(model);

		if (!result.hasErrors())
		{
			editUserCreditWith(accountUser, result);
			mailService.sendMail();
		}

		if (result.hasErrors())
		{
			return new ModelAndView("withCredit", "userWithCredit", accountUser);
		}
			return new ModelAndView("redirect:/account", "userWithCredit", accountUser);
	}

	@RequestMapping(value = "/withCredit", method = RequestMethod.GET)
	public String showCreditFormWith(Model model, WebRequest request)
	{
		super.populateUser(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user1 = userService.findUserByEmail(auth.getName());
		final UserDataTransferEdit user = new UserDataTransferEdit();
		model.addAttribute("userGet", user1);
		model.addAttribute("userWithCredit", new UserDataTransferEditCredit());
		return "withCredit";
	}

	private User editUserCreditWith(UserDataTransferEditCredit account, BindingResult result)
	{
		User registered;

		try
		{
			registered = userService.withCredit(account);
		}
		catch (Exception e)
		{
			result.rejectValue("credit", "casino.edit.notNull.credit");
			return null;
		}
		return registered;
	}

}
