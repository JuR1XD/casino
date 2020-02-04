package com.packt.casino.Service;

import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransfer;
import com.packt.casino.exceptions.EmailExistsException;

import java.util.Optional;


public interface UserService
{
	void add(String name, String surname,  String email,  String birthday, String password, String street, String streetNr, String postalCode, String city);
	void remove(Long userId);
	void update(Long userId, String name, String surname,  String email,  String birthday, double credit, boolean admin, boolean isActivated, String Password, String street, String streetNr, String postalCode, String city);
	Optional<User> findById(Long userId);
	User registerNewUserAccount(UserDataTransfer user) throws EmailExistsException;
	Iterable<User> findAll();
}
