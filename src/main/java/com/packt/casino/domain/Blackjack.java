package com.packt.casino.domain;

public class Blackjack extends GamblingGame
{
	int cardUserOne;
	int cardUserTwo;
	int cardEnemyOne;
	int cardEnemyTwo;

	@Override
	public boolean play()
	{
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
