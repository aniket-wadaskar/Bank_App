package com.bankapp.service;

import java.util.List;

import com.bankapp.dto.AccountDTO;
import com.bankapp.entity.Account;

public interface AccountService {
	
	Account createAccount(AccountDTO accountDto);
	
	AccountDTO getAccountById(Long id);
	
	String deleteAccount(Long id);
	
	String updateAccount(Long id,AccountDTO accountDto);
	
	List<Account> allAccount(Account account);

}
