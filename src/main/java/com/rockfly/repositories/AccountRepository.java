package com.rockfly.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	 @Query("select a from Account a where a.email = :email")
	   Optional<Account> findOneByEmailIgnoreCase(String email);
}
