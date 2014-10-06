package com.jusoft.ligaregional.persistencia.modelo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "temporadas", uniqueConstraints = 
		@UniqueConstraint(columnNames = {"fecha_inicio", "fecha_fin" }))
public class Temporada extends AbstractModelo<Long> {

	private static final long serialVersionUID = 5577948490985769186L;
	private Long id;
	private Date fechaInicio;
	private Date fechaFin;
	private Set<Equipo> equipos = new HashSet<>();
	private Set<Jugador> jugadores = new HashSet<>();
	private Set<Partido> partidos = new HashSet<>();
	
	public Temporada() {
	}

	public Temporada(Timestamp fechaInicio, Timestamp fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Temporada(Timestamp fechaInicio, Timestamp fechaFin,
			Set<Jugador> jugadores, Set<Equipo> equipos,
			Set<Partido> partidos) {
		this(fechaInicio,fechaFin);
		this.jugadores = jugadores;
		this.equipos = equipos;
		this.partidos = partidos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "temporada_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 10)
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 10)
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temporada")
	public Set<Equipo> getEquipos() {
		return equipos;
	}
	
	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temporada")
	public Set<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temporada")
	public Set<Partido> getPartidos() {
		return partidos;
	}
	
	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}
}
