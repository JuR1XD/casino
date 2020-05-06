package com.packt.casino.domain.factories;

import com.packt.casino.Service.GamePlayingService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class GamblingGame
{

	double stake;
	double multiplier;

	public double calcProfit()
	{
		return stake * multiplier;
	}

	public abstract boolean play();

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

	public void setMultiplier(double multiplier)
	{
		this.multiplier = multiplier;
	}
}
