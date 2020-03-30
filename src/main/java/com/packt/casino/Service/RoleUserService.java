package com.packt.casino.Service;

import com.packt.casino.domain.AdminUserDataTransferRole;
import com.packt.casino.domain.RoleUser;
import org.springframework.web.bind.annotation.PathVariable;


public interface RoleUserService
{
	RoleUser editUserAccountAdmin(AdminUserDataTransferRole accountUser, @PathVariable Long id);
}
