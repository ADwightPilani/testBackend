package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface User1Repository extends JpaRepository<User1,Long>{
	User1 findByUsername(String Name);
	
	List<User1> findAll();
	
	User1 findByUsernameAndPassword(String username, String password);
	
	@Query(value = "Select * from user", nativeQuery = true)
    List<Object[]> findAllUsers();
    
}
