package com.spring.maxgames.PostRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.maxgames.PostModel.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
