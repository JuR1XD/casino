package com.packt.casino.Service.Impl;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import com.packt.casino.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("UserService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;


	User user = new User();


	@Override
	public  void add(String name, String surname,  String email,  String birthday, String password, String street, String streetNr, String postalCode, String city)
	{
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setBirthday(birthday);
		user.setStreet(street);
		user.setStreetNr(streetNr);
		user.setPostalCode(postalCode);
		user.setCity(city);
		user.setCredit(0);
		user.setAdmin(false);
		user.setIsActivated(true);
		user.setPassword(password);
		userRepository.save(user);
	}

	@Override
	public void remove(Long userId)
	{
		userRepository.deleteById(userId);
	}

	@Override
	public void update(Long userId, String name, String surname,  String email,  String birthday, double credit, boolean admin, boolean isActivated, String password, String street, String streetNr, String postalCode, String city)
	{

		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setBirthday(birthday);
		user.setStreet(street);
		user.setStreetNr(streetNr);
		user.setPostalCode(postalCode);
		user.setCity(city);
		user.setCredit(credit);
		user.setAdmin(admin);
		user.setIsActivated(isActivated);
		user.setPassword(password);
		userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long userId)
	{
		return userRepository.findById(userId);
	}

	@Override
	public Iterable<User> findAll()
	{
		return userRepository.findAll();
	}
}
