package com.jusoft.ligaregional.persistencia.modelo;

import java.io.Serializable;

public interface Modelo <ID extends Serializable>{

	void setId(ID identificador);
	ID getId();
}
