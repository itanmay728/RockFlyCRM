package com.rockfly.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.rockfly.models.Account;
import com.rockfly.repositories.RolesRepository;
import com.rockfly.services.RolesService;
import com.rockfly.services.Impl.AccountServiceImpl;
import com.rockfly.models.Roles ;

@Component
public class SeedData implements CommandLineRunner{
	
	@Autowired
	private AccountServiceImpl accountService;
	
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private RolesService rolesService;

	@Override
	public void run(String... args) throws Exception {
		
		//check if roles already exists if not then saving some roles 
		 if(!rolesService.roleExists("USER") && !rolesService.roleExists("ADMIN") && !rolesService.roleExists("MANAGER")) {

	        	List<String> rolesList = new ArrayList<>();
	        	
	        	rolesList.add("USER");
	        	rolesList.add("ADMIN");
	        	rolesList.add("MANAGER");
	        	
	        	for(int i = 0; i<rolesList.size(); i++) {
	        		Roles roles = new Roles();
	        		roles.setRole(rolesList.get(i));
	        		rolesRepository.save(roles);
	        	}
	        	
	        }
		
		// Check if admin account already exists if not then saving admin account
        if (!accountService.adminExists("admin@rockfly.com")) {
            Account account1 = new Account();
            account1.setEmail("admin@rockfly.com");
            account1.setPassword("123");
            account1.setName("admin");
            
            Roles role =  rolesRepository.findByRole("ADMIN");
            
            account1.addRole(role);
            accountService.saveAccountByDefaultRole(account1);
        }
        
       

	}

}
