package com.packt.casino.domain.search;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class SearchVariables
{
	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	String searchInput;

	@NotBlank(message = "{casino.signIn.notNull}")
	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	String release;

	@NotBlank(message = "{casino.signIn.notNull}")
	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	String secondDate;

	public String getRelease()
	{
		return release;
	}

	public void setRelease(String release)
	{
		this.release = release;
	}

	public String getSearchInput()
	{
		return searchInput;
	}

	public void setSearchInput(String searchInput)
	{
		this.searchInput = searchInput;
	}

	public String getSecondDate()
	{
		return secondDate;
	}

	public void setSecondDate(String secondDate)
	{
		this.secondDate = secondDate;
	}
}
