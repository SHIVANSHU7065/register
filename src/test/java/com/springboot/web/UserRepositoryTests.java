package com.springboot.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	 @Autowired
	 private TestEntityManager entityManager;
	 
	 @Autowired
	 private UserRepository repo;
	 @Test
	 public void testCreateUser() {
	     user user = new user();
	     user.setEmail("ravikumar@gmail.com");
	     user.setPassword("ravi2020");
	     user.setFirstName("Ravi");
	     user.setLastName("Kumar");
	      
	     user savedUser = repo.save(user);
	      
	     user existUser = entityManager.find(user.class, savedUser.getId());
	      
	     assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	      
	 }
	
	 @Test
	 public void testFindUserByEmail()
	 {
		 String email="name@codejava.net";
		  user user =repo.findByEmail(email);
		  assertThat(user).isNotNull();
	 }
}
