package com.packt.casino.domain.UserDataTransferClasses;

import javax.validation.constraints.NotNull;


public class AdminUserDataTransferRole
{

	@NotNull(message = "{casino.signIn.notNull}")
	private Long authorityId;

	public Long getAuthorityId()
	{
		return authorityId;
	}

	public void setAuthorityId(Long authorityId)
	{
		this.authorityId = authorityId;
	}
}
