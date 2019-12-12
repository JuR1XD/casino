package com.packt.casino.domain;

public class Game
{
	private String gameId;
	private String name;
	private double min;
	private String description;
	private boolean isActivated;

	public Game()
	{
		super();
	}

	public Game(String gameId, String name, double min)
	{
		this.gameId = gameId;
		this.name = name;
		this.min = min;
	}

	public String getGameId()
	{
		return gameId;
	}

	public void setGameId(String gameId)
	{
		this.gameId = gameId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getMin()
	{
		return min;
	}

	public void setMin(double min)
	{
		this.min = min;
	}

	public boolean isActivated()
	{
		return isActivated;
	}

	public void setActivated(boolean activated)
	{
		isActivated = activated;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
