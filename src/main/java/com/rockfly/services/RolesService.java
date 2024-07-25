package com.rockfly.services;

import java.util.List;

import com.rockfly.models.Roles;

public interface RolesService {

	List<Roles> getAllRoles();

	boolean roleExists(String email);
}
