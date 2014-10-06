package com.jusoft.ligaregional.persistencia.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "polideportivos")
public class Polideportivo extends AbstractModelo<Long> {

	private static final long serialVersionUID = 4133202642952623302L;
	private Long id;
	private String nombre;
	private Direccion direccion;
	private Integer camposDisponibles;
	private Set<Partido> partidos = new HashSet<>();
	
	public Polideportivo() {
	}

	public Polideportivo(String nombre, Direccion direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Polideportivo(String nombre, Direccion direccion, Integer camposDisponibles,
			Set<Partido> partidos) {
		this(nombre,direccion);
		this.camposDisponibles = camposDisponibles;
		this.partidos = partidos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "polideportivo_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Embedded
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Column(name = "campos_disponibles", nullable = false)
	public Integer getCamposDisponibles() {
		return camposDisponibles;
	}
	
	public void setCamposDisponibles(Integer camposDisponibles) {
		this.camposDisponibles = camposDisponibles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "polideportivo")
	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}
}
