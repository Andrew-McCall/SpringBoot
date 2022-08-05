package com.qa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	Account findByfirstName(String firstName);

	@Query(value = "SELECT * from Account WHERE email = ?1 Limit 1", nativeQuery = true)
	Account findAccountByEmail(String email);

}
