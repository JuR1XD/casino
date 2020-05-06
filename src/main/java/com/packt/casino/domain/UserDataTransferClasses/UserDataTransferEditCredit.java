package com.packt.casino.domain.UserDataTransferClasses;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class UserDataTransferEditCredit
{


	@NotNull(message = "{casino.signIn.notNull}")
	@Min(value = 0, message = "{casino.edit.min}")
	//@Pattern(regexp = "[0-100]", message = "You can only deposit 100 Credits at a time")
	private Double credit;

	public Double getCredit()
	{
		return credit;
	}

	public void setCredit(Double credit)
	{
		this.credit = credit;
	}

}