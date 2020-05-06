package com.packt.casino.controllers;

import com.packt.casino.Service.RoleUserService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.UserDataTransferClasses.AdminUserDataTransfer;
import com.packt.casino.domain.UserDataTransferClasses.AdminUserDataTransferRole;
import com.packt.casino.domain.RoleUser;
import com.packt.casino.domain.User;
import com.packt.casino.domain.repository.RoleUserRepository;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController
{
	@Autowired
	UserService userService;

	@Autowired
	private RoleUserRepository roleUserRepository;

	@Autowired
	private RoleUserService roleU;

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
	public ModelAndView displayEditUserForm(@PathVariable Long id, Model model, WebRequest request)
	{
		super.populateUser(model);
		ModelAndView mav = new ModelAndView("editUserAdmin");
		User user = userService.getUserById(id);
		RoleUser role = roleUserRepository.findByUserId(user.getUserId());

		mav.addObject("headerMessage", "Edit User Details");
		user.setPassword("");
		mav.addObject("userAdmin", user);
		mav.addObject("userEditAdmin", new AdminUserDataTransfer());
		mav.addObject("userAuthorities", new AdminUserDataTransferRole());
		mav.addObject("authorities", role);
		return mav;
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedUser(
			@ModelAttribute("userEditAdmin") @Valid AdminUserDataTransfer accountUser,
			@ModelAttribute("userAuthorities") AdminUserDataTransferRole accountUserRole,
			BindingResult result, Model model, @PathVariable Long id, WebRequest request)
	{
		super.populateUser(model);
		if (!result.hasErrors())
		{
			editUserAccount(accountUser, result, id);
			editUserRoleAdmin(accountUserRole, result, id);
		}

		if (result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("editUserAdmin", "userEditAdmin", accountUser);
			mav.addObject("userAdmin", accountUser);
			return mav;
		}
		return new ModelAndView("redirect:/admin/allUsers", "userEditAdmin", accountUser);

	}

	private User editUserAccount(AdminUserDataTransfer account, BindingResult result, @PathVariable Long id)
	{
		User registered;

		try
		{
			registered = userService.editUserAccountAdmin(account, id);
		}
		catch (EmailExistsException e)
		{
			result.rejectValue("email", "casino.signIn.emailMatch.error");
			return null;
		}
		return registered;
	}

	private RoleUser editUserRoleAdmin(AdminUserDataTransferRole account, BindingResult result,
			@PathVariable Long id)
	{
		RoleUser registered;
		registered = roleU.editUserAccountAdmin(account, id);

		return registered;
	}

}
