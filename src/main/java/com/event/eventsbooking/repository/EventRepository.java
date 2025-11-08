package com.event.eventsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.eventsbooking.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
