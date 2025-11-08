package com.event.eventsbooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.eventsbooking.model.Event;
import com.event.eventsbooking.service.EventService;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

	private EventService service;

	public EventController(EventService service) {
		this.service = service;
	}
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.saveEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
	 
	   
	   
}
