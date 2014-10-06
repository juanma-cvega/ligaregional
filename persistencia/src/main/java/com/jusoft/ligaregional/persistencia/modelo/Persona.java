package com.jusoft.ligaregional.persistencia.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Persona extends AbstractBean{

	private static final long serialVersionUID = 7420136417323155986L;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	
	public Persona(){}
	
	public Persona(String nombre, String apellido1, String dni){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.dni = dni;
	}
	
	public Persona(String nombre, String apellido1, String apellido2, String dni){
		this(nombre,apellido1,apellido2);
		this.apellido2 = apellido2;
	}
	
	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido1", nullable = false, length = 50)
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	@Column(name = "apellido2", length = 50)
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	@Column(name = "dni", nullable = false, length = 9)
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
}
