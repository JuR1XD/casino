package com.packt.casino.domain.playVariables;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class PlayVariablesRouletteTest
{

	@Pattern(regexp = "(^[1-9]$|^1[0-9]$|^2[0-9]|^3[0-5]$)", message = "Bitte geben sie eine korrekte Zahl ein")
	@NotNull(message = "{casino.signIn.notNull}")
	private String userInput;

	public String getUserInput()
	{
		return userInput;
	}

	public void setUserInput(String userInput)
	{
		this.userInput = userInput;
	}
}
