package com.rockfly.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rockfly.models.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	Roles findByRole(String role);
	
	@Query("select a from Roles a where a.role = :role")
	Optional<Roles> findbyrolename(String role);
}
