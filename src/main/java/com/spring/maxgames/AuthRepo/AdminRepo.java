package com.spring.maxgames.AuthRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.maxgames.AuthModel.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Admin findByUsername(String username);

}
