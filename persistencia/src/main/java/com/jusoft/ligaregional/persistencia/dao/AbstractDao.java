package com.jusoft.ligaregional.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AbstractDao <T, ID extends Serializable>{

	T guardar(T objetoParaGuardar);

	T cargar(ID identificadorObjeto);

	void actualizar(T objetoParaActualizar);

	void borrar(T objetoParaBorrar);
	
	void borrar(ID identificadorObjeto);
	
	List<T> obtenerTodos();
}
