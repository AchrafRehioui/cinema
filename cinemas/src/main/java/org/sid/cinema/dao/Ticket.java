package org.sid.cinema.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double price;
	private String NameCustomer;
	private int CodePaiement;
	private boolean booked;
	@ManyToOne
	private Position position;
	@ManyToOne
	private Projection projection;
	
	
}
