package com.packt.casino.domain.search;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class SearchVariables
{
	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	String searchInput;

	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	String release;

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
}
