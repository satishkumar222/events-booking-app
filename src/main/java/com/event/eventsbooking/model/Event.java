package com.event.eventsbooking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
 	 private String title;

     private String description;
     private LocalDateTime start_time;
 	 private LocalDateTime end_time;
     
     @ManyToOne
     @JoinColumn(name="venue_id")
     private Venue venue; 
}
