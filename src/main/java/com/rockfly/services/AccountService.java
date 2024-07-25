package com.rockfly.services;

import java.util.List;

import com.rockfly.models.Account;

public interface AccountService {

	Account saveAccountByDefaultRole(Account account);
	
	public void saveAccount(Account account);
	
	boolean adminExists(String email);
	
	public List<Account> getAllAccount();
	
	public Account getAccountById(Long id);
	

}
