package com.spring.maxgames.AuthRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.maxgames.AuthModel.Auth;

public interface AuthRepo extends JpaRepository<Auth, Integer> {
	Auth findByusername(String username);
}
