package com.qa.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entities.Account;
import com.qa.entities.AccountDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@Sql(scripts = { "classpath:person-schema.sql",
//		"classpath:person-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ObjectMapper jsonifier;

	private AccountDTO mapToDTO(Account account) {
		return mapper.map(account, AccountDTO.class);
	}

	private final Long TEST_ID = 4L;
	private final Account TEST_ACCOUNT = new Account(null, "Barry", "blue", "puddle");

	@Test
	public void create() {

		Account expected = TEST_ACCOUNT;
		expected.setId(TEST_ID);

		try {

			mock.perform(get("/create").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_ACCOUNT)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void create2() {

		Account expected = TEST_ACCOUNT;
		expected.setId(TEST_ID);

		try {

			mock.perform(post("/create").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_ACCOUNT)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
