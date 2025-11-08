package com.event.eventsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.eventsbooking.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
