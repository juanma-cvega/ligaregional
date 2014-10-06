
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
import javax.persistence.UniqueConstraint;


/**
 * 
 * @author Kilian
 *
 */
@Entity
@Table(name = "arbitros", uniqueConstraints = {
		@UniqueConstraint(columnNames = "dni"),
		@UniqueConstraint(columnNames = "numero_colegiado") })
public class Arbitro extends AbstractModelo<Long> {

	private static final long serialVersionUID = -7802133074558586091L;
	private Long id;
	private Persona persona = new Persona();
	private String numeroColegiado;
	private Direccion direccion = new Direccion();
	private Set<Partido> partidos = new HashSet<Partido>();

	public Arbitro() {
	}

	public Arbitro(Persona persona,Direccion direccion,String numeroColegiado) {
		this.persona = persona;
		this.direccion = direccion;
		this.numeroColegiado = numeroColegiado;
	}

	public Arbitro(Persona persona,Direccion direccion,String numeroColegiado,
			Set<Partido> partidos) {
		this(persona,direccion,numeroColegiado);
		this.partidos = partidos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arbitro_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Embedded
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "numero_colegiado", unique = true, nullable = false, length = 50)
	public String getNumeroColegiado() {
		return numeroColegiado;
	}

	public void setNumeroColegiado(String numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}

	@Embedded
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "arbitro")
	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}
}
