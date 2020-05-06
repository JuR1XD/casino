package com.packt.casino.Service;

import com.packt.casino.domain.*;
import com.packt.casino.domain.UserDataTransferClasses.*;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService
{
	void add(String name, String surname,  String email,  String birthday, String password, String street, String streetNr, String postalCode, String city);
	void remove(Long userId);
	void update(Long userId, String name, String surname,  String email,  String birthday, double credit, boolean admin, boolean isActivated, String Password, String street, String streetNr, String postalCode, String city);
	Optional<User> findById(Long userId);
	User registerNewUserAccount(UserDataTransfer user) throws EmailExistsException;
	User editUserAccount(UserDataTransferEdit accountUser) throws EmailExistsException;
	List getAllUsers();
	User findUserByEmail(String email);
	User findUserByAddress(Long address);
	User findUserByName(String name);
	User findUserBySurname(String surname);
	public User getUserById(Long id);
	public boolean saveUser(User user);
	public boolean deleteUserById(Long id);
	public User editPassword(UserDataTransferEditPw accountUser) throws Exception;
	public boolean checkPassword(UserDataTransferEditPw userDataTransferEditPw);
	public User addCredit(UserDataTransferEditCredit accountUser) throws Exception;
	public User withCredit(UserDataTransferEditCredit accountUser) throws Exception;
	public User editUserAccountAdmin(AdminUserDataTransfer accountUser, @PathVariable Long id) throws EmailExistsException;
}
