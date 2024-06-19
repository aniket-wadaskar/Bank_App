package com.bankapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.bankapp.dto.AccountDTO;
import com.bankapp.entity.Account;
import com.bankapp.exception.AccountNotFoundException;
import com.bankapp.repository.AccountRepository;
import com.bankapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(AccountDTO accountDto) {
		Account account = new Account();
		account.setId(accountDto.getId());
		account.setAccountHolderName(accountDto.getAccountHolderName());
		account.setBalance(accountDto.getBalance());
		
		accountRepository.save(account);
		return account;
	}

	@Override
	public AccountDTO getAccountById(Long id) {
		
		
		Account account  = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with ID "+ id + " not Found"));
		
		AccountDTO accountDto = new AccountDTO();
		
		accountDto.setId(account.getId());
		accountDto.setAccountHolderName(account.getAccountHolderName());
		accountDto.setBalance(account.getBalance());
		return accountDto;
	}

	public String deleteAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account with ID "+ id + " not Found"));
		accountRepository.delete(account);
		return "Succefully deleted";
	}
	
	@Override
	
	public String updateAccount(Long id,AccountDTO accountDto) {
		
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account with ID "+ id + " not Found"));
		if(account.getAccountHolderName() != null) {
			account.setAccountHolderName(accountDto.getAccountHolderName());
		}
		if(account.getBalance() != 0) {
			account.setBalance(accountDto.getBalance());
		}
		accountRepository.save(account);
		
		return "Account Updated !!!";
		
	}
	
	public List<Account> allAccount(Account account){
		
		List<Account> accounts = accountRepository.findAll(); 
		return accounts;
		
		
	}

	
	
	
	
	
	
	
	

}
