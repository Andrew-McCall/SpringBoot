package com.qa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.AccountRepo;
import com.qa.entities.Account;

@Service
public class AccountService {
	
	private AccountRepo repo;
    
	@Autowired
    public AccountService(AccountRepo repo) {
        super();
        this.repo = repo;
    }
        
    public Account addAccount(Account account) {
    	return this.repo.save(account);
    }

    public List<Account> getAllAccounts() {
        return repo.findAll();
	}
    
    public Account searchEmail(String email) {
    	return repo.findAccountByEmail(email);
    }
    
    public Account searchName(String firstName){
    	return repo.findByfirstName(firstName);
    }
    
    public Account getOneAccount(long id) {
        return repo.findById(id).orElse(null);
	}

	public Account updateAccount(Long id, Account account) {
		Optional<Account> existingOptional = this.repo.findById(id);
		Account existing = existingOptional.orElse(new Account());
		
        existing.setEmail(account.getEmail());
        existing.setFirstName(account.getFirstName());
        existing.setLastName(account.getLastName());
        
        return this.repo.save(existing);
	}

	public boolean removeAccount(Long id) {
		repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
        return !exists;
	}

}
