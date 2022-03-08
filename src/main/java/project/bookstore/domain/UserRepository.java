package project.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	// Spring Security need to find users by username
	User findByUsername(String username);

}
