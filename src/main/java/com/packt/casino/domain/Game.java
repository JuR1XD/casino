package com.packt.casino.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "game")
public class Game
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@NotEmpty
	@Column(name = "gameId", table = "game")
	private Long gameId;
	@NotNull
	@NotEmpty
	@Column(name = "name", table = "game")
	private String name;
	@NotNull
	@NotEmpty
	@Column(name = "min", table = "game")
	private double min;
	@NotNull
	@NotEmpty
	@Column(name = "description", table = "game")
	private String description;
	@NotNull
	@NotEmpty
	@Column(name = "isActivated", table = "game")
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
