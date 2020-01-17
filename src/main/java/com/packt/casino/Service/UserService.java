package com.packt.casino.Service;

import com.packt.casino.domain.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


public interface UserService
{
	void add(User user, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String birthday, @RequestParam String street, @RequestParam String streetNr, @RequestParam String postalCode, @RequestParam String city);
	void remove();
	void update(User user);
	Optional<User> findById();
	Iterable<User> findAll();
}
