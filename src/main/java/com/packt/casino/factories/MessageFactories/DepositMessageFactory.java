package com.packt.casino.factories.MessageFactories;

import com.packt.casino.factories.EmailMessageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


/*@PropertySources({ @PropertySource("classpath:messages_de.properties"),
		@PropertySource("classpath:messages_en.properties") })*/
public class DepositMessageFactory extends EmailMessageFactory
{

	public DepositMessageFactory()
	{
		setTemplate("Hallo %s %s,\n\nSie haben %.02f € auf ihr Konto eingezahlt.\nMit Freundlichen Grüßen\n\nDas Valantic Kasino");
		setSubject("Auf ihr Konto wurde Geld eingezahlt");
	}
}
