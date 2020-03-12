package com.packt.casino.Service.factories.MessageFactories;

import com.packt.casino.Service.factories.EmailMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import java.util.Locale;


public class DepositMessageFactory extends EmailMessageFactory
{
	public DepositMessageFactory(@Value("${casino.deposit.subject}") String subject, @Value("${casino.deposit.message}")String template)
	{
		setTemplate(template);
		setSubject(subject);
	}
}
