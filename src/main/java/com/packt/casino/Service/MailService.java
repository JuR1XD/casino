package com.packt.casino.Service;

import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferEditCredit;
import org.springframework.beans.factory.annotation.Value;


public interface MailService
{
	void sendMailWith(UserDataTransferEditCredit userData, User user, @Value("{casino.withdraw.subject}") String subject, @Value("{casino.withdraw.message}") String template);
	void sendMailAdd(UserDataTransferEditCredit userData, User user, @Value("{casino.deposit.subject}") String subjectWith, @Value("{casino.deposit.message}") String templateWith);
}
