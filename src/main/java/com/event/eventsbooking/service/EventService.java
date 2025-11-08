package com.event.eventsbooking.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.event.eventsbooking.model.Event;
import com.event.eventsbooking.repository.EventRepository;

@Service
public class EventService {

	 private EventRepository eventRepo;
    
    public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    public List<Event> getAllEvents() {
        Predicate<Event> futureEvents = e -> e.getStart_time().isAfter(java.time.LocalDateTime.now());
        return eventRepo.findAll().stream()
                .filter(futureEvents)
                .collect(Collectors.toList());
    }

    
    public Optional<Event> getEventById(Long id) {
        return eventRepo.findById(id);
    }

    
    public void deleteEvent(Long id) {
    	eventRepo.deleteById(id);
    }
	   
}
