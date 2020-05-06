package com.packt.casino.Service.Impl;

import com.packt.casino.Service.MailService;
import com.packt.casino.Service.UserService;
import com.packt.casino.Service.factories.MessageFactories.DepositMessageFactory;
import com.packt.casino.Service.factories.MessageFactories.WithdrawMessageFactory;
import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEditCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
@PropertySource("classpath:application.properties")
public class MailServiceImpl implements MailService
{
	Locale locale = LocaleContextHolder.getLocale();

	String getLocale = locale.getCountry();

	@Autowired
	UserService userService;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.from}")
	private String fromMail;

	@Override
	public void sendMailWith(UserDataTransferEditCredit userData, User user)
	{
		WithdrawMessageFactory withdraw = new WithdrawMessageFactory();

		SimpleMailMessage message = withdraw.generateEmail(userData, user);
		message.setFrom(fromMail);
		message.setTo(user.getEmail());
		mailSender.send(message);
	}

	@Override
	public void sendMailAdd(UserDataTransferEditCredit userData, User user)
	{
		DepositMessageFactory deposit = new DepositMessageFactory();

		SimpleMailMessage message = deposit.generateEmail(userData, user);

		message.setFrom(fromMail);
		message.setTo(user.getEmail());
		mailSender.send(message);
	}
}
