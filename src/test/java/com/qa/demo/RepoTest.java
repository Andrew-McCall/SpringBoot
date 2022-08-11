package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.entities.Account;
import com.qa.repos.AccountRepo;
import com.qa.runner.QaSpringApplication;

@SpringBootTest(classes = { QaSpringApplication.class })
@ActiveProfiles("test")
public class RepoTest {

	@Autowired
	private AccountRepo repo;

	@BeforeEach
	public void dbWipe() {

	}

	@Test
	public void read() {

		Optional<Account> expected = Optional.of(new Account(1L, "Andrew", "McCall", "amccall@qa.com", null));

		assertEquals(this.repo.findById((long) 1), expected);

	}

}
