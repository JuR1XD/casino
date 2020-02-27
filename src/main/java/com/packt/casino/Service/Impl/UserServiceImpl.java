package com.packt.casino.Service.Impl;

import com.packt.casino.Service.UserService;
import com.packt.casino.domain.Authority;
import com.packt.casino.domain.User;
import com.packt.casino.domain.UserDataTransfer;
import com.packt.casino.domain.repository.AuthorityRepository;
import com.packt.casino.domain.repository.UserRepository;
import com.packt.casino.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;


@Service("UserService")
public class UserServiceImpl implements UserService
{

	private UserRepository userRepository;

	private AuthorityRepository authorityRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User findUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByAddress(Long address)
	{
		return userRepository.findByAddressId(address);
	}

	@Override
	public User findUserByName(String name)
	{
		return userRepository.findByName(name);
	}

	@Override
	public User findUserBySurname(String surname)
	{
		return userRepository.findBySurname(surname);
	}



	User user = new User();


	@Override
	public void add(String name, String surname, String email, String birthday, String password,
			String street, String streetNr, String postalCode, String city)
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
		//user.setAdmin(false);
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
	public void update(Long userId, String name, String surname, String email, String birthday, double credit,
			boolean admin, boolean isActivated, String password, String street, String streetNr,
			String postalCode, String city)
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
		//user.setAdmin(admin);
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

	@Transactional
	@Override
	public User registerNewUserAccount(UserDataTransfer accountUser) throws EmailExistsException
	{
		if (emailExist(accountUser.getEmail()))
		{
			throw new EmailExistsException("There is an Account with that email address:" + accountUser.getEmail());
		}

		User user = new User();
		user.setName(accountUser.getName());
		user.setSurname(accountUser.getSurname());
		user.setEmail(accountUser.getEmail());
		user.setBirthday(accountUser.getBirthday());
		user.setStreet(accountUser.getStreet());
		user.setStreetNr(accountUser.getStreetNr());
		user.setPostalCode(accountUser.getPostalCode());
		user.setCity(accountUser.getCity());
		user.setPassword(bCryptPasswordEncoder.encode(accountUser.getPassword()));
		Authority userAuthority = authorityRepository.findAuthorityByName("ROLE_USER");
		user.setAuthorities(new HashSet<Authority>(Arrays.asList(userAuthority)));
		user.setActivated(true);
		user.setCredit(0.00);
		return userRepository.save(user);
	}

	private boolean emailExist(String email)
	{
		User user = userRepository.findByEmail(email);
		if (user != null)
		{
			return true;
		}
		return false;
	}

}
