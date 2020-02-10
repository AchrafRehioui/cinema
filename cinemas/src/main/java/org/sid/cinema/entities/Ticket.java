package org.sid.cinema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	@Column(unique=false, nullable=true)
	private int CodePaiement;
	
	private boolean booked;
	
	@ManyToOne
	private Position position;
	
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	private Projection projection;
	
	
}
