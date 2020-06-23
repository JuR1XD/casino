package com.packt.casino.controllers;

import com.packt.casino.Service.MailService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.*;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEdit;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEditCredit;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEditPw;
import com.packt.casino.domain.repository.RoleUserRepository;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	private RoleUserRepository roleUserRepository;

	@RequestMapping
	public ModelAndView list(Model model)
	{
		super.populateUser(model);
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		RoleUser role = roleUserRepository.findByUserId(user.getUserId());
		mav.addObject("userName", user.getName() + " " + user.getSurname());
		mav.addObject("userNamePt2", user.getName() + " " + user.getSurname());
		mav.addObject("userEmail", user.getEmail());
		mav.addObject("userBirthday", user.getBirthday());
		mav.addObject("userAddress", user.getStreet() + " " + user.getStreetNr());
		mav.addObject("userAddressPt2", user.getPostalCode());
		mav.addObject("userAddressPt3", user.getCity());
		mav.addObject("currentMoney", user.getCredit());
		if (role.getAuthorityId() == 1)
		{
			mav.addObject("authority", "Admin");
		}
		else if(role.getAuthorityId() == 2)
		{
			mav.addObject("authority", "User");
		}

		mav.addObject("getAuthority", role.getAuthorityId());
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
			ModelAndView mav = new ModelAndView("editUser", "userEdit", accountUser);
			mav.addObject("userGet", accountUser);
			return mav;
		}

		if (accountUser.getEmail().contains(user.getEmail()))
		{
			return new ModelAndView("redirect:/account", "userEdit", accountUser);
		}
		else
		{
			return new ModelAndView("redirect:/logout?logout=true&userChange=true", "userEdit", accountUser);
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
			WebRequest request, Errors errors, @RequestParam(value = "error", required = false) String error,
			@Value("${casino.signIn.passwordMatch.error}") String message)
	{
		super.populateUser(model);


		if (!accountUser.getPassword().equals(accountUser.getMatchingPassword()) && !accountUser
				.getMatchingPassword().equals(accountUser.getPassword()))
		{
			ModelAndView mav = new ModelAndView("editPassword", "passwordEdit", accountUser);
			mav.addObject("error", message);
			return mav;
		}
		if (!accountUser.getPassword().equals(accountUser.getMatchingPassword()) || !accountUser
				.getMatchingPassword().equals(accountUser.getPassword()))
		{
			ModelAndView mav = new ModelAndView("editPassword", "passwordEdit", accountUser);
			mav.addObject("error", message);
			return mav;
		}
		if (!result.hasErrors())
		{
			editUserAccountPassword(accountUser, result);
		}
		if (result.hasErrors())
		{
			return new ModelAndView("editPassword", "passwordEdit", accountUser);
		}

		return new ModelAndView("redirect:/logout?logout=true&passwordChange=true", "passwordEdit", accountUser);
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
			result.rejectValue("oldPassword", "casino.edit.password.wrongOldPassword");
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		User registered;

		try
		{
			registered = userService.addCredit(account);
			mailService.sendMailAdd(account, user);
		}
		catch (Exception e)
		{
			result.rejectValue("credit", "casino.edit.notNull.credit");
			return null;
		}
		return registered;
	}

	@RequestMapping(path = "/withCredit", method = RequestMethod.POST)
	public ModelAndView updateUserCreditWith(Model model,
			@ModelAttribute("userWithCredit") @Valid UserDataTransferEditCredit accountUser,
			BindingResult result, WebRequest request, Errors errors)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		super.populateUser(model);

		if (!result.hasErrors())
		{
			editUserCreditWith(accountUser, result);
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		User registered;

		try
		{
			registered = userService.withCredit(account);
			mailService.sendMailWith(account, user);
		}
		catch (Exception e)
		{
			result.rejectValue("credit", "casino.edit.notNull.credit");
			return null;
		}
		return registered;
	}
}
