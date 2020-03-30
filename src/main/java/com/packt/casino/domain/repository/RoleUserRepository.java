package com.packt.casino.domain.repository;

import com.packt.casino.domain.RoleUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleUserRepository extends CrudRepository<RoleUser, Long>
{
	RoleUser findByUserId(Long userId);
}
