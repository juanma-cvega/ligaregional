package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;

public abstract class AbstractDaoMyBatis<T extends AbstractModelo<ID>, ID extends Serializable> implements AbstractDao<T, ID>{

	protected AbstractDaoMyBatisMapper<T, ID> abstractDaoMapper;
	
	@Override
	public void actualizar(T objetoParaActualizar) {
		abstractDaoMapper.actualizar(objetoParaActualizar);
	}

	@Override
	public void borrar(T objetoParaBorrar) {
		abstractDaoMapper.borrar(objetoParaBorrar.getId());
	}
	
	@Override
	public void borrar(ID identificadorObjeto){
		abstractDaoMapper.borrar(identificadorObjeto);
	}

	@Override
	public T guardar(T objetoParaGuardar) {
		abstractDaoMapper.guardar(objetoParaGuardar);
		return objetoParaGuardar;
	}

	@Override
	public T cargar(ID identificador) {
		return abstractDaoMapper.cargar(identificador);
	}

	@Override
	public List<T> obtenerTodos(){
		return abstractDaoMapper.obtenerTodos();
	}
}
