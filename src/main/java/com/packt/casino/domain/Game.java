package com.packt.casino.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Game
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gameId;
	private String name;
	private double min;
	private String description;
	private boolean isActivated;

	@Override
	public String toString() {
		return String.format(
				"Game[gameid=%d, name='%s', min='%s', description='%s', isActivated=%s]",
				gameId, name, min, description, isActivated);
	}


	public Long getGameId()
	{
		return gameId;
	}

	public void setGameId(Long gameId)
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
