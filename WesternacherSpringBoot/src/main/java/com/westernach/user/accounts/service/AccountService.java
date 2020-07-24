package com.westernach.user.accounts.service;

import java.util.List;

import com.westernach.user.accounts.exceptions.AccountNotFoundException;
import com.westernach.user.accounts.model.Account;

public interface AccountService {
	List<Account> getAllAcounts();
	void saveAccount(Account account);
	Account getAccountById(long id) throws AccountNotFoundException;
	void deleteAccountById(long id);
	
}
