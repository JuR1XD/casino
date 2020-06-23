package com.packt.casino.factories.MessageFactories;

import com.packt.casino.factories.EmailMessageFactory;

public class WithdrawMessageFactory extends EmailMessageFactory
{
	public WithdrawMessageFactory()
	{
		setTemplate("Hallo %s %s,\n\nSie haben %.02f € auf von ihrem Konto abgehoben.\nMit Freundlichen Grüßen\n\nDas Valantic Kasino");
		setSubject("Sie haben Geld von ihrem Kasino Konto abgehoben");
	}
}
