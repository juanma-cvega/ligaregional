package com.jusoft.ligaregional.persistencia.modelo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author Kilian
 *
 */
@Entity
@Table(name = "partidos", uniqueConstraints = 
		@UniqueConstraint(columnNames = {"temporada", "local", "visitante" }))
public class Partido extends AbstractModelo<Long> {

	private static final long serialVersionUID = -8927495800429427025L;
	private Long id;
	private Equipo local;
	private Equipo visitante;
	private Temporada temporada;
	private Arbitro arbitro;
	private Polideportivo polideportivo;
	private Date fecha;
	
	public Partido() {
	}

	public Partido(Equipo local, Arbitro arbitros,
			Polideportivo polideportivo, Equipo visitante,
			Temporada temporada, Timestamp fecha) {
		this.local = local;
		this.arbitro = arbitros;
		this.polideportivo = polideportivo;
		this.visitante = visitante;
		this.temporada = temporada;
		this.fecha = fecha;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partido_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "local", nullable = false)
	public Equipo getLocal() {
		return local;
	}
	
	public void setLocal(Equipo local) {
		this.local = local;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visitante", nullable = false)
	public Equipo getVisitante() {
		return visitante;
	}
	
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temporada", nullable = false)
	public Temporada getTemporada() {
		return temporada;
	}
	
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "arbitro", nullable = false)
	public Arbitro getArbitro() {
		return arbitro;
	}
	
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "polideportivo", nullable = false)
	public Polideportivo getPolideportivo() {
		return polideportivo;
	}
	
	public void setPolideportivo(Polideportivo polideportivo) {
		this.polideportivo = polideportivo;
	}

	@Column(name = "fecha", nullable = false, length = 19)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
