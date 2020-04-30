package com.packt.casino.domain;

import java.util.Random;


public class Bandid extends GamblingGame
{
	Random ran = new Random();

	int numberOne;
	int numberTwo;
	int numberThree;





	@Override
	public boolean play()
	{
		numberOne = ran.nextInt(4) + 1;
		numberTwo = ran.nextInt(4) + 1;
		numberThree = ran.nextInt(4) + 1;

		setMultiplier(3);
		if (numberOne == numberTwo)
		{
			return numberTwo == numberThree;
		}
		else
		{
			return false;
		}
	}

	public int getNumberOne()
	{
		return numberOne;
	}

	public void setNumberOne(int numberOne)
	{
		this.numberOne = numberOne;
	}

	public int getNumberTwo()
	{
		return numberTwo;
	}

	public void setNumberTwo(int numberTwo)
	{
		this.numberTwo = numberTwo;
	}

	public int getNumberThree()
	{
		return numberThree;
	}

	public void setNumberThree(int numberThree)
	{
		this.numberThree = numberThree;
	}
}
