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
	public  void add(User user)
	{
		user.setUserid(17L);
		user.setName("Maximillian");
		user.setSurname("Mustermann");
		user.setEmail("max.mustermann@bespiel.de");
		user.setBirthday("01.01.2000");
		user.setStreet("beispiel Straße");
		user.setStreetnr("1a");
		user.setPostalcode("12345");
		user.setCity("Musterhausen");
		user.setCredit(0);
		user.setAdmin(false);
		user.setIsactivated(true);
		userRepository.save(user);
	}

	@Override
	public void remove()
	{
		userRepository.deleteById(21L);
	}

	@Override
	public void update(User user)
	{
		user.setUserid(17L);
		user.setName("André");
		user.setSurname("Vilgis");
		user.setEmail("andre.vilgis@bespiel.de");
		user.setBirthday("01.01.20001");
		user.setStreet("beispiel Straße");
		user.setStreetnr("22");
		user.setPostalcode("12345");
		user.setCity("Hofheim");
		user.setCredit(200);
		user.setAdmin(true);
		user.setIsactivated(true);
		userRepository.save(user);
	}

	@Override
	public Optional<User> findById()
	{
		return userRepository.findById(17L);
	}

	@Override
	public Iterable<User> findAll()
	{
		return userRepository.findAll();
	}
}
