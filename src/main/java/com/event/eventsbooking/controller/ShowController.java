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

import com.event.eventsbooking.model.Show;
import com.event.eventsbooking.service.ShowService;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

	  private ShowService showService;

	public ShowController(ShowService showService) {
		super();
		this.showService = showService;
	}
	@PostMapping
	public Show CreateShow(@RequestBody Show show) {
		return showService.CreateShow(show);
	}
	@GetMapping
	public List<Show> getAllShows(){
		return showService.showList();
	}
	@GetMapping("/{id}")
	public Optional<Show> getShowById(@PathVariable Long id) {
		return showService.getShowById(id) ;
		
	}
	@DeleteMapping("/{id}")
	  public void deleteShow(@PathVariable Long id) {
		 showService.deleteById(id);
	  }
	  
}
