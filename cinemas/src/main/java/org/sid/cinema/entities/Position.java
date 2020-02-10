package org.sid.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Position {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int seatnumber;
	
	
	@ManyToOne
	private Moviestheater moviestheater;
	
	
	@OneToMany(mappedBy="position")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Ticket> tickets;
	
	
}
