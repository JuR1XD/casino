package com.packt.casino.Service.Impl;

import com.packt.casino.Service.MailService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@PropertySource("classpath:application.properties")
public class MailServiceImpl implements MailService
{
	@Autowired
	UserService userService;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.from}")
	private String fromMail;

	@Override
	public void sendMail()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(fromMail);
		message.setTo(user.getEmail());
		message.setSubject("Test");
		message.setText("This is a test E-Mail");
		mailSender.send(message);
	}
}
