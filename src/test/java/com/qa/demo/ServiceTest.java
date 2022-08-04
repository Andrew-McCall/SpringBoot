package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.controllers.AccountService;
import com.qa.entities.Account;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ServiceTest {

	@Autowired
	AccountService service;

	@MockBean
	AccountRepo repo;

	@Test
	public void testCreate() {

//	    public Account addAccount(Account account) {
//    	return this.repo.save(account);
//    }

		Account account = new Account(null, "Andrew", "McCall", "Email");

		Mockito.when(repo.save(account)).thenReturn(account);

		assertEquals(service.addAccount(account), account);

		Mockito.verify(this.repo, Mockito.times(1)).save(account);

	}

}
