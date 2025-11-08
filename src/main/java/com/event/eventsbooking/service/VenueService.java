package com.event.eventsbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.eventsbooking.model.Venue;
import com.event.eventsbooking.repository.VenueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VenueService {
      
	  private final VenueRepository venueRepo;

	//create venue
      public Venue createVenue(Venue venue) {    	  
		return venueRepo.save(venue);
    	  
      }
      
      //get all venues
      public List<Venue> getAllVenues(){
		return venueRepo.findAll();
    	  
      }
      
      // get venue by id
      
      public Optional<Venue> getByVenueId(Long id) {
		return venueRepo.findById(id);
    	  
      }
      public void deleteVenue(Long id) {
    	  venueRepo.deleteById(id);
      }
}
