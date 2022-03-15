package project.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class BookstoreRestTest {
	
	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	// Check if endpoint status response is Ok
	@Test 
	public void booklistStatusOk() throws Exception {
		mockMvc.perform(get("/booklist"))
			.andExpect(status().is2xxSuccessful());
	}
	
	// Check if endpoint with book id status response is Ok
	@Test 
	public void booklistIdStatusOk() throws Exception {
		mockMvc.perform(get("/booklist/2"))
			.andExpect(status().is2xxSuccessful());
	}
	
	// Check if REST returns JSON
	@Test 
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/booklist"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void apiStatusOk() throws Exception {
		mockMvc.perform(get("/api/books")).andExpect(status().is2xxSuccessful());
	}
}
