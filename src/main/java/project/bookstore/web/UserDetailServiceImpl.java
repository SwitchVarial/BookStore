package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.bookstore.domain.User;
import project.bookstore.domain.UserRepository;

// Used for authentication and authorization
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;

	
	// UserRepository used for User Detail Service Implementation
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	// User details for authentication and authorization including user role
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User currentuser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(currentuser.getRole()));
		return user;
		
	}

}
