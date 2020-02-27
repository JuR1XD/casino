package com.packt.casino.domain.repository;

import com.packt.casino.domain.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long>
{
	Authority findAuthorityByName(String name);
}
