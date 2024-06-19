package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDTO;
import com.bankapp.entity.Account;
import com.bankapp.exception.AccountNotFoundException;
import com.bankapp.serviceimpl.AccountServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@PostMapping("/createAcc")
	public Account createAccount(@RequestBody AccountDTO accountDto) {
		
		return accountServiceImpl.createAccount(accountDto);
		
	}
	
	@GetMapping("/accountById/{id}")
	public Object getAccountById(@PathVariable(value="id") long id) {
		try{return accountServiceImpl.getAccountById(id);
		}catch(AccountNotFoundException e){
			return e.getMessage();
			
		}
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public String deletAccount(@PathVariable(value="id")long id) {
		try {return accountServiceImpl.deleteAccount(id);
		
		}catch(AccountNotFoundException e) {
			return e.getMessage();
		}
	}
	
	@PutMapping("/update/{id}")
	
	public String updateAccount(@PathVariable(value="id")long id,@RequestBody AccountDTO accountDTO) {
try {return accountServiceImpl.updateAccount(id, accountDTO);
		
		}catch(AccountNotFoundException e) {
			return e.getMessage();
		}
		
	}
	
	@GetMapping("/allAccounts")
	public List<Account> allAccount(@RequestBody Account account){
		return accountServiceImpl.allAccount(account);
	}
	
	
	

}
