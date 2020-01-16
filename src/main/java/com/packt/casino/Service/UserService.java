package com.packt.casino.Service;

import com.packt.casino.domain.User;

import java.util.Optional;


public interface UserService
{
	void add(User user);
	void remove();
	void update(User user);
	Optional<User> findById();
	Iterable<User> findAll();
}
