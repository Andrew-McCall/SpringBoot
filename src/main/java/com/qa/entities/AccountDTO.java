package com.qa.entities;

public class AccountDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String Email;

	public AccountDTO(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = email;
	}

	public AccountDTO(Account account) {
		super();
		this.id = account.getId();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.Email = account.getEmail();
	}
	
	public AccountDTO() {
		super();
	}
	
	public Long setId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Email=" + Email
				+ "]";
	}
	
}
