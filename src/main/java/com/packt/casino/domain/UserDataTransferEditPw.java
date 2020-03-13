package com.packt.casino.domain;

import com.packt.casino.validator.PasswordMatches;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class UserDataTransferEditPw
{

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String oldPassword;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "{casino.signIn.password.validPassword}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	private String password;
	@NotEmpty(message = "{casino.signIn.notNull}")
	private String matchingPassword;


	public String getOldPassword()
	{
		return oldPassword;
	}

	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMatchingPassword()
	{
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword)
	{
		this.matchingPassword = matchingPassword;
	}

}
