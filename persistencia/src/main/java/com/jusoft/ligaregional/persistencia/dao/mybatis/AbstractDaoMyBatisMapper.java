package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;

public interface AbstractDaoMyBatisMapper<T extends AbstractModelo<ID>, ID extends Serializable> {

	int guardar(T objetoParaGuardar);
	
	T cargar(ID identificador);

	void actualizar(T objetoParaGuardar);
	
	void borrar(ID identificador);
	
	List<T> obtenerTodos();
}
