package com.packt.casino.Service.Impl;

import com.packt.casino.Service.RoleUserService;
import com.packt.casino.domain.AdminUserDataTransferRole;
import com.packt.casino.domain.RoleUser;
import com.packt.casino.domain.User;
import com.packt.casino.domain.repository.RoleUserRepository;
import com.packt.casino.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class RoleUserServiceImpl implements RoleUserService
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleUserRepository roleUserRepository;

	@Override
	public RoleUser editUserAccountAdmin(AdminUserDataTransferRole accountUser, @PathVariable Long id)
	{
		User user = userRepository.findUserByUserId(id);
		RoleUser role = roleUserRepository.findByUserId(user.getUserId());

		role.setAuthorityId(accountUser.getAuthorityId());

		return roleUserRepository.save(role);
	}
}
