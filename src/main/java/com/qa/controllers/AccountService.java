package com.qa.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entities.Account;
import com.qa.entities.AccountDTO;
import com.qa.exceptions.AccountNotFound;
import com.qa.repos.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;

	private ModelMapper mapper;

	private AccountDTO mapToDTO(Account account) {
		return mapper.map(account, AccountDTO.class);
	}

	@Autowired
	public AccountService(AccountRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public Account addAccount(Account account) {
		return this.repo.save(account);
	}

	public List<AccountDTO> getAllAccounts() {
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public Account searchEmail(String email) {
		return repo.findAccountByEmail(email);
	}

	public Account searchName(String firstName) {
		return repo.findByfirstName(firstName);
	}

	public Account getOneAccount(long id) {
		return repo.findById(id).orElseThrow(AccountNotFound::new);
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
		if (exists == false) {
			throw new AccountNotFound();
		}
		return !exists;
	}

}
