package com.jusoft.ligaregional.servicios.impl;

import java.io.Serializable;
import java.util.List;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;
import com.jusoft.ligaregional.servicios.AbstractService;

public abstract class AbstractServiceImpl<T extends AbstractModelo<ID>,ID extends Serializable> implements AbstractService<T, ID> {

	protected AbstractDao<T, ID> dao;

	public T guardar(T objetoParaGuardar) {
		return dao.guardar(objetoParaGuardar);
	}
	
	public T cargar(ID identificador){
		return dao.cargar(identificador);
	}
	
	public void actualizar(T objetoParaActualizar){
		dao.actualizar(objetoParaActualizar);
	}
	
	public void borrar(ID identificadorObjeto){
		dao.borrar(identificadorObjeto);
	}
	
	public List<T> obtenerTodos(){
		return dao.obtenerTodos();
	}
}

