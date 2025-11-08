package com.event.eventsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.eventsbooking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
