package com.jusoft.ligaregional.persistencia.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion extends AbstractBean {

	private static final long serialVersionUID = 1702039407144418945L;
	private String calle;
	private String ciudad;
	private String provincia;
	private String codigoPostal;
	
	public Direccion(){}
	
	public Direccion(String calle, String ciudad, String provincia, String codigoPostal){
		this.calle = calle;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}
	
	@Column(name = "calle", nullable = false, length = 200)
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	@Column(name = "ciudad", nullable = false, length = 50)
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Column(name = "provincia", nullable = false, length = 50)
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Column(name = "codigo_postal", nullable = false, length = 50)
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
}
