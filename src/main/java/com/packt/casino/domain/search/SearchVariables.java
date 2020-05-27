package com.packt.casino.domain.search;

import javax.validation.constraints.NotNull;


public class SearchVariables
{
	@NotNull
	String searchInput;

	public String getSearchInput()
	{
		return searchInput;
	}

	public void setSearchInput(String searchInput)
	{
		this.searchInput = searchInput;
	}
}
