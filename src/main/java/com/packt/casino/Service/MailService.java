package com.packt.casino.Service;

import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransferClasses.UserDataTransferEditCredit;


public interface MailService
{
	void sendMailWith(UserDataTransferEditCredit userData, User user);
	void sendMailAdd(UserDataTransferEditCredit userData, User user);
}
