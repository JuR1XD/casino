package com.packt.casino.Service.factories.MessageFactories;

import com.packt.casino.Service.factories.EmailMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import java.util.Locale;


public class DepositMessageFactory extends EmailMessageFactory
{
	public DepositMessageFactory()
	{
		setTemplate("Hallo %s %s,\n\nSie haben %.02f € auf ihr Konto eingezahlt.\nMit Freundlichen Grüßen\n\nDas Valantic Kasino");
		setSubject("Auf ihr Konto wurde Geld eingezahlt");
	}
}
