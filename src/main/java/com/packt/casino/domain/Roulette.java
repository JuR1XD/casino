package com.packt.casino.domain;

import java.util.Random;


public class Roulette extends GamblingGame
{
	Random ran = new Random();

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
