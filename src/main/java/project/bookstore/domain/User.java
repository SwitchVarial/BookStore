package project.bookstore.domain;

import javax.persistence.*;

@Entity
public class User {
	
	// User id, not null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Username, not null, unique
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // Password, encryted, not null
    @Column(name = "password", nullable = false)
    private String passwordHash;

    // Role, not null
    @Column(name = "role", nullable = false)
    private String role;

	public User() {
	}

	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
