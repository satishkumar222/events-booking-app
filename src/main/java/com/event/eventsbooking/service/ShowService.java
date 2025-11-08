package com.event.eventsbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.event.eventsbooking.model.Show;
import com.event.eventsbooking.repository.ShowRepository;

@Service
public class ShowService {

	 private ShowRepository showRepo;
	 
	 public ShowService(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}

	public Show CreateShow(Show show) {
		 return showRepo.save(show);
	 }
	 
	 public List<Show> showList(){
		return showRepo.findAll();
		 
	 }
	 
	public  Optional<Show> getShowById(Long id) {
		return showRepo.findById(id);
		
	}
	
	public void deleteById(Long id) {
		showRepo.deleteById(id);
	}
	
	
}
