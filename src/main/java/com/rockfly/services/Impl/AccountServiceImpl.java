package com.rockfly.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rockfly.models.Account;
//import com.rockfly.models.Authority;
import com.rockfly.repositories.AccountRepository;
import com.rockfly.repositories.RolesRepository;
import com.rockfly.services.AccountService;
import com.rockfly.models.Roles;

@Service
public class AccountServiceImpl implements UserDetailsService, AccountService{

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Account saveAccountByDefaultRole(Account account) {
		System.out.println(account.getPassword());
		System.out.println(account.getName());

		
		String encodedPassword=passwordEncoder.encode(account.getPassword());

		account.setPassword(encodedPassword);
		
		account.setEmail(account.getEmail());
		
		account.setName(account.getName());
		account.setAddress(account.getAddress());
		account.setAadhaar(account.getAadhaar());
		account.setCity(account.getCity());
		account.setPhone(account.getPhone());
		account.setPincode(account.getPincode());
		
		Roles role =  rolesRepository.findByRole("USER");
        
        account.addRole(role);
	
		return accountRepository.save(account);
	}
	
	@Override
	public List<Account> getAllAccount() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long id) {
		
		return accountRepository.findById(id).get();
	}

	@Override
	public void saveAccount(Account account) {
		String encodedPassword=passwordEncoder.encode(account.getPassword());

		account.setPassword(encodedPassword);
		
		
		accountRepository.save(account);
	}
	
	@Override
	 public boolean adminExists(String email) {
	        return accountRepository.findOneByEmailIgnoreCase(email).isPresent();
	    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Account> optionalAccount = accountRepository.findOneByEmailIgnoreCase(username);

		if (!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Account not found");
		}
		Account account = optionalAccount.get();

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		Set<Roles> roles = account.getRoles();
		
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		
		for(Roles r : roles) {
			simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+r.getRole()));
		}
		
		grantedAuthorities.addAll(simpleGrantedAuthorities);
		
		return new User(account.getEmail(), account.getPassword(), grantedAuthorities);
	}

	
}
