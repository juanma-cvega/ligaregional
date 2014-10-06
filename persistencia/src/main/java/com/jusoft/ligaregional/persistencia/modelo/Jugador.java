package com.jusoft.ligaregional.persistencia.modelo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author Kilian
 *
 */
@Entity
@Table(name = "jugadores", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "equipo", "dni" }),
		@UniqueConstraint(columnNames = { "temporada", "dni" }) })
public class Jugador extends AbstractModelo<Long>{

	private static final long serialVersionUID = 4339556199615777759L;
	private Long id;
	private Equipo equipo;
	private Temporada temporada;
	private Boolean capitan;
	private Persona persona;
	
	public Jugador() {
	}

	public Jugador(Equipo equipo, Temporada temporada, Persona persona, boolean capitan) {
		this.equipo = equipo;
		this.temporada = temporada;
		this.persona = persona;
		this.capitan = capitan;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jugador_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo", nullable = false)
	public Equipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temporada", nullable = false)
	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	@Column(name = "capitan", nullable = false, columnDefinition = "BIT")
	public Boolean getCapitan() {
		return capitan;
	}
	
	public void setCapitan(Boolean capitan) {
		this.capitan = capitan;
	}

	@Embedded
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
