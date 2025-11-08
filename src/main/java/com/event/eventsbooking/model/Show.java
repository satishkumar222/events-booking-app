package com.event.eventsbooking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="show")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @ManyToOne(fetch = FetchType.EAGER)  
	  @JoinColumn(name="event_id")
	  private Event event;
	  
	  private LocalDateTime showTime;
	  private int totalSeats;
	  private int availableSeats;
	  
	  
}
