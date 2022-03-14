package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.bookstore.domain.User;
import project.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	// Find category by name
	@Test
	public void findByUsernameReturnUsername() {
		User user = userRepository.findByUsername("admin");
		Assertions.assertThat(user.getUsername()).isEqualTo("admin");
	}
	
	// Insert new category
	@Test
	public void insertNewUser() {
		User user = new User("seller", "$2a$10$pJTPGPzrntDLBVVXKrOtA.Zy4BQvW2UsMOpPE7xcLhsRZfjmyI9.q", "SELLER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	// Delete category
	@Test 
	public void deleteUser() { 
		User user = userRepository.findByUsername("user");
		userRepository.deleteById(user.getId());
		user = userRepository.findByUsername("user");
		Assertions.assertThat(user).isNull();
	}

}
