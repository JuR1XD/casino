package com.packt.casino.domain.factories;

import java.util.Random;


public class Blackjack extends GamblingGame
{
	int cardUserOne;
	int cardUserTwo;
	int cardEnemyOne;
	int cardEnemyTwo;
	Random ran = new Random();


	@Override
	public boolean play()
	{

		cardUserOne = ran.nextInt(11)+1;
		cardUserTwo = ran.nextInt(11)+1;
		cardEnemyOne = ran.nextInt(11)+1;
		cardEnemyTwo = ran.nextInt(11)+1;

		setMultiplier(2);
		if(cardUserOne + cardUserTwo == cardEnemyOne + cardEnemyTwo)
		{
			return false;
		}
		if(cardUserOne + cardUserTwo > cardEnemyOne + cardEnemyTwo)
		{
			return false;
		}
		return cardUserOne + cardUserTwo < cardEnemyOne + cardEnemyTwo;

	}

	@Override
	public boolean forceWin()
	{
		cardUserOne = ran.nextInt(11)+1;
		cardUserTwo = ran.nextInt(11)+1;
		cardEnemyOne = cardUserOne -1;
		cardEnemyTwo = cardUserTwo -1;

		return true;

	}

	public int getCardUserOne()
	{
		return cardUserOne;
	}

	public void setCardUserOne(int cardUserOne)
	{
		this.cardUserOne = cardUserOne;
	}

	public int getCardUserTwo()
	{
		return cardUserTwo;
	}

	public void setCardUserTwo(int cardUserTwo)
	{
		this.cardUserTwo = cardUserTwo;
	}

	public int getCardEnemyOne()
	{
		return cardEnemyOne;
	}

	public void setCardEnemyOne(int cardEnemyOne)
	{
		this.cardEnemyOne = cardEnemyOne;
	}

	public int getCardEnemyTwo()
	{
		return cardEnemyTwo;
	}

	public void setCardEnemyTwo(int cardEnemyTwo)
	{
		this.cardEnemyTwo = cardEnemyTwo;
	}
}
