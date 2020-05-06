package com.packt.casino.Service.factories;

import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEditCredit;
import org.springframework.mail.SimpleMailMessage;


public abstract class EmailMessageFactory
{
	private	String template;

	private String subject;

	public SimpleMailMessage generateEmail(UserDataTransferEditCredit userData, User user)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(getSubject());
		message.setText(String.format(getTemplate(), user.getName(), user.getSurname(), userData.getCredit()));
		return message;
	}

	public String getTemplate()
	{
		return template;
	}

	public void setTemplate(String template)
	{
		this.template = template;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
}
