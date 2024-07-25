package com.rockfly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>{

	//search
//	@Query("select a from Account a where a.email = :email")
	 @Query("SELECT c FROM Customers c WHERE c.shopName LIKE %:keywords% OR c.partyName LIKE %:keywords% OR c.email LIKE %:keywords% OR c.state LIKE %:keywords% OR c.city LIKE %:keywords%")
	 public List<Customers> findByPartyNameOrCityContaining(String keywords);
}
