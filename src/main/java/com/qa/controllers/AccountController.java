package com.qa.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entities.Account;

@Service
@RestController
public class AccountController {
	
	@GetMapping("/")
	public String home(){
		return "<h1>Hello World!</h1>";
	}
	
	private AccountService service;

	@Autowired
    public AccountController(AccountService service) {
        super();
        this.service = service;
    }
    
    @GetMapping("/getAll")
    public List<Account> getAll(){
    	return service.getAllAccounts();
    }
    
    @GetMapping("/search")
    public Account search(@PathParam("email") String email, @PathParam("firstName") String firstName){
    	if (email != null) {
    		return service.searchEmail(email);
    	}if (firstName != null){
    		return service.searchName(firstName);
    	}else {
    		return null;
    	}
    	
    }
    
    @PostMapping("/create")
    public Account create(@RequestBody Account account){
    	return service.addAccount(account);
    }
    
    @PostMapping("/delete")
    public boolean delete(@PathParam("id") Long id) {
    	return service.removeAccount(id);
    }
    
    @PostMapping("/update")
    public Account update(@PathParam("id") Long id, @RequestBody Account account) {
    	return service.updateAccount(id, account);
    }
    
    @GetMapping("getOne")
    public Account getOne(@PathParam("id") Long id) {
    	return service.getOneAccount(id);
    }
    
}
