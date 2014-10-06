package com.jusoft.ligaregional.persistencia.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * 
 * @author Kilian
 *
 */
@Entity
@Table(name = "equipos", uniqueConstraints = 
		@UniqueConstraint(columnNames = {"temporada", "nombre" }))
public class Equipo extends AbstractModelo<Long> {

	private static final long serialVersionUID = -4148834257241274083L;
	private Long id;
	private Temporada temporada;
	private String nombre;
	private Set<Jugador> jugadores = new HashSet<>();
	private Set<Partido> partidosComoLocal = new HashSet<>();
	private Set<Partido> partidosComoVisitante = new HashSet<>();

	public Equipo() {
	}

	public Equipo(Temporada temporadas, String nombre) {
		this.temporada = temporadas;
		this.nombre = nombre;
	}

	public Equipo(Temporada temporada, String nombre,Set<Partido> partidosComoLocal,
			Set<Partido> partidosComoVisitante, Set<Jugador> jugadores) {
		this(temporada,nombre);
		this.partidosComoLocal = partidosComoLocal;
		this.partidosComoVisitante = partidosComoVisitante;
		this.jugadores = jugadores;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipo_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temporada", nullable = false)
	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "local")
	public Set<Partido> getPartidosComoLocal() {
		return partidosComoLocal;
	}

	public void setPartidosComoLocal(Set<Partido> partidosComoLocal) {
		this.partidosComoLocal = partidosComoLocal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "visitante")
	public Set<Partido> getPartidosComoVisitante() {
		return partidosComoVisitante;
	}

	public void setPartidosComoVisitante(Set<Partido> partidosComoVisitante) {
		this.partidosComoVisitante = partidosComoVisitante;
	}
}
