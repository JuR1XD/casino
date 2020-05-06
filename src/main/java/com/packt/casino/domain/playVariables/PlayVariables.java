package com.packt.casino.domain.playVariables;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public abstract  class PlayVariables
{
	@NotNull(message = "{casino.signIn.notNull}")
	@Pattern(regexp = ("^[0-9]+[,.]+[0-9][0-9]$|^[0-9]+$"), message = "Bitte geben sie eine Zahl ein")
	@NotEmpty
	private String stake;

	@NotNull(message = "{casino.signIn.notNull}")
	private double multiplier;


	public String getStake()
	{
		return stake;
	}

	public void setStake(String stake)
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
