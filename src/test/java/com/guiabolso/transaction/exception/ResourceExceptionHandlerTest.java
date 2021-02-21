package com.guiabolso.transaction.exception;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ResourceExceptionHandlerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void noHandlerFoundExceptionTest() throws Exception {
		mockMvc.perform(get("/1/2", 1000).contentType(APPLICATION_JSON)).andExpect(status().isNotFound());
	}

	@Test
	public void numberFormatExceptionTest() throws Exception {
		mockMvc.perform(get("/{id}/transacoes/{ano}/{mes}", "q", 2007, 10).contentType(APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void methodArgumentTypeMismatchExceptionTest() throws Exception {
		mockMvc.perform(get("/{id}/transacoes/{ano}/{mes}", "q", 2007, "q").contentType(APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
}
