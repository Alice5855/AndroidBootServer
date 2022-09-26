package com.springboot.androidapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.androidapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	User save(User user);
	
	User findByUserId(String id);

}