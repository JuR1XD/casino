package com.packt.casino.domain;

import javax.validation.constraints.NotNull;


public class PlayVariables
{

	@NotNull
	private double stake;

	@NotNull
	private double multiplier;

	@NotNull
	private int userInput;


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
