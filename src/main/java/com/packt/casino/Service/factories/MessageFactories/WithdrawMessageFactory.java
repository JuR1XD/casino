package com.packt.casino.Service.factories.MessageFactories;

import com.packt.casino.Service.factories.EmailMessageFactory;

public class WithdrawMessageFactory extends EmailMessageFactory
{
	public WithdrawMessageFactory(String subject, String template)
	{
		setTemplate(template);
		setSubject(subject);
	}
}
