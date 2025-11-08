package com.event.eventsbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.eventsbooking.model.Booking;
import com.event.eventsbooking.model.Show;
import com.event.eventsbooking.repository.BookingRepository;
import com.event.eventsbooking.repository.ShowRepository;

@Service
public class BookingService {
 
	private final BookingRepository bookingRepo;
    private final ShowRepository showRepo;
    
	public BookingService(BookingRepository bookingRepo, ShowRepository showRepo) {
		super();
		this.bookingRepo = bookingRepo;
		this.showRepo = showRepo;
	}
    
	public Booking createBooking(Long showId,Booking booking) {
		
		Show show=showRepo.findById(showId).
				orElseThrow(()->new RuntimeException("Show Id not found"));
		
		// 1️⃣ Check available seats
		if(booking.getSeatsBooked()>show.getAvailableSeats()) {
			 throw new RuntimeException("Not enough seats available");
		}
		
		   // 2️⃣ Update available seats
		show.setAvailableSeats(show.getAvailableSeats() - booking.getSeatsBooked());
		
		 // 3️⃣ Link booking with show
		booking.setShow(show);
		
		 // 4️⃣ Calculate price
        double ticketPrice = 250.0;
        booking.setTotalAmount(ticketPrice * booking.getSeatsBooked());

        // 5️⃣ Save both updated show and booking
        showRepo.save(show);
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public void deleteBooking(Long id) {
    	bookingRepo.deleteById(id);
    }
    
	 
}
