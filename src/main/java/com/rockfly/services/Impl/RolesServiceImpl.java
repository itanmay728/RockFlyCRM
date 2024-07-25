package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.Roles;
import com.rockfly.repositories.RolesRepository;
import com.rockfly.services.RolesService;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<Roles> getAllRoles() {
		
		return rolesRepository.findAll();
	}
	
	@Override
	 public boolean roleExists(String email) {
	        return rolesRepository.findbyrolename(email).isPresent();
	    }

}
