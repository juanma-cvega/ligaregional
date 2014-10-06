package com.jusoft.ligaregional.servicios;

import java.io.Serializable;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;

public interface AbstractService<T extends AbstractModelo<ID>, ID extends Serializable> {

	T guardar(T objetoParaGuardar);
	
	T cargar(ID identificador);
	
	void actualizar(T objetoParaActualizar);
	
	void borrar(ID identificadorObjeto);
	
	List<T> obtenerTodos();
}
