package com.spring.maxgames.AuthRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.maxgames.AuthModel.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
