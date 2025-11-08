package com.event.eventsbooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.eventsbooking.model.Venue;
import com.event.eventsbooking.service.VenueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {

	   private final VenueService venueService;
	   
	   @PostMapping
	   public Venue CreateVenue(@RequestBody Venue venue) {
		return venueService.createVenue(venue);
		   
	   }
	   
	    @GetMapping
	    public List<Venue> getAllVenues() {
	        return venueService.getAllVenues();
	    }

	    @GetMapping("/{id}")
	    public Optional<Venue> getVenueById(@PathVariable Long id) {
	        return venueService.getByVenueId(id);
	    }
	   
	   
}
