package com.packt.casino.domain.factories;

import com.packt.casino.Service.GamePlayingService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class GamblingGame
{

	private double stake;
	private double multiplier;
	int counter;
	int userInput;



	public double calcProfit()
	{
		return stake * multiplier;
	}

	public abstract boolean play();

	public boolean testPlay()
	{
		counter++;

		if(counter % 3 == 0)
		{
			return this.forceWin();
		}
		else
		{
			return this.play();
		}
	}

	public abstract boolean forceWin();

	public double getStake()
	{
		return stake;
	}

	public void setStake(double stake)
	{
		this.stake = stake;
	}

	public double getMultiplier()
	{
		return multiplier;
	}

	protected void setMultiplier(double multiplier)
	{
		this.multiplier = multiplier;
	}
	public int getUserInput()
{
	return userInput;
}

	public void setUserInput(int userInput)
	{
		this.userInput = userInput;
	}
}
