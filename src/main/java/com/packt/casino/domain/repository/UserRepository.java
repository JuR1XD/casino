package com.packt.casino.domain.repository;

import com.packt.casino.domain.User;

import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	User findByName(String name);
	User findBySurname(String surname);
	User findByAddressId(Long addressId);
}
