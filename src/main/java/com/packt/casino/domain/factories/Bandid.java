package com.packt.casino.domain.factories;

import java.util.Random;


public class Bandid extends GamblingGame
{
	Random ran = new Random();

	int numberOne;
	int numberTwo;
	int numberThree;


	public Bandid()
	{
		setMultiplier(3);
	}

	@Override
	public boolean play()
	{
		numberOne = ran.nextInt(4) + 1;
		numberTwo = ran.nextInt(4) + 1;
		numberThree = ran.nextInt(4) + 1;

		return numberOne == numberTwo && numberTwo == numberThree;
	}

	@Override
	public boolean forceWin()
	{
		numberOne = ran.nextInt(4) + 1;
		numberTwo = numberOne;
		numberThree = numberTwo;

		return true;
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
