package project.bookstore;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookstoreRestTest {
	
	@Autowired
	private MockMvc mockMvc;
	
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
