package com.packt.casino.Service;

import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferEditCredit;
import org.springframework.beans.factory.annotation.Value;


public interface MailService
{
	void sendMailWith(UserDataTransferEditCredit userData, User user);
	void sendMailAdd(UserDataTransferEditCredit userData, User user);
}
