package com.packt.casino.domain.factories;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Random;


public class Roulette extends GamblingGame
{
	Random ran = new Random();

	@NotNull(message = "{casino.signIn.notNull}")
	@Pattern(regexp = "(^[1-9]$|^1[0-9]$|^2[0-9]|^3[0-5]$)", message = "Bitte geben sie eine korrekte Zahl ein")
	int userInput;
	int gameInput;

	@Override
	public boolean play()
	{

		gameInput = ran.nextInt(35) + 1;
		setMultiplier(35);
		if (userInput == gameInput)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean forceWin()
	{
		gameInput = userInput;

		return true;
	}

	public int getUserInput()
	{
		return userInput;
	}

	public void setUserInput(int userInput)
	{
		this.userInput = userInput;
	}

	public int getGameInput()
	{
		return gameInput;
	}

	public void setGameInput(int gameInput)
	{
		this.gameInput = gameInput;
	}
}
