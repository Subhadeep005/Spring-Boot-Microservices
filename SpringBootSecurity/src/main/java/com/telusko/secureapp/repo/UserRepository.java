package com.telusko.secureapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.secureapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
