package com.spring.maxgames.EventRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.maxgames.EventModel.Events;

public interface EventsRepo extends JpaRepository<Events, Long> {

}
