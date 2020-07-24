package com.westernach.user.accounts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.westernach.user.accounts.exceptions.AccountNotFoundException;
import com.westernach.user.accounts.model.Account;
import com.westernach.user.accounts.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> getAllAcounts() {
		return (List<Account>) accountRepository.findAll(Sort.by("firstName"));
	}

	@Override
	public void saveAccount(Account account) {
		this.accountRepository.save(account);

	}

	@Override
	public Account getAccountById(long id) throws AccountNotFoundException {
		Optional<Account> optional = accountRepository.findById(id);
		Account account = null;
		if(optional.isPresent()) {
			account = optional.get();
		} else {
			throw new AccountNotFoundException(id);
		}
		
		return account;
	}

	@Override
	public void deleteAccountById(long id) {
		this.accountRepository.deleteById(id);;
	}


}
