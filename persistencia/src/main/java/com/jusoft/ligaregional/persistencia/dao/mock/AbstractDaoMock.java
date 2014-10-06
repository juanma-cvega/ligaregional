package com.jusoft.ligaregional.persistencia.dao.mock;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;
import com.jusoft.ligaregional.persistencia.utils.RelanzadorExcepciones;

public class AbstractDaoMock<T extends AbstractModelo<Long>, ID extends Serializable> implements AbstractDao<T, Long> {

	private List<T> listadoObjetosMock;
	
	private Class<T> clasePersistida;

	@SuppressWarnings("unchecked")
	public AbstractDaoMock() {
		this.listadoObjetosMock = new ArrayList<T>();
		this.clasePersistida = (Class<T>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		try{
			T newInstance = clasePersistida.newInstance();
			newInstance.setId(1L);
			listadoObjetosMock.add(newInstance);
		} catch(Exception e){
			RelanzadorExcepciones.lanzar(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T guardar(T objetoParaGuardar) {
		objetoParaGuardar = crearNuevoIdParaObjeto(objetoParaGuardar);
		anhadirdObjeto((T) objetoParaGuardar.clone());
		return objetoParaGuardar;
	}
	
	private T crearNuevoIdParaObjeto(T objetoParaGuardar){
		Long idNuevoObjeto = (long) (listadoObjetosMock.size() + 1);
		objetoParaGuardar.setId(idNuevoObjeto);
		return objetoParaGuardar;
	}

	@Override
	public T cargar(Long identificador) {
		return getObjetoDelListado(identificador);
	}

	@Override
	public void actualizar(T objetoParaActualizar) {
		T objetoRecuperado = getObjetoDelListado(objetoParaActualizar.getId());
		borrar(objetoRecuperado);
		anhadirdObjeto(objetoParaActualizar);
	}

	@Override
	public void borrar(T objetoParaBorrar) {
		borrar(objetoParaBorrar.getId());
	}
	
	@Override
	public void borrar(Long identificadorObjeto){
		T objetoEncontrado = null;
		for (T objeto : listadoObjetosMock) {
			if (objeto.getId() == identificadorObjeto){
				objetoEncontrado = objeto;
			}
		}
		listadoObjetosMock.remove(objetoEncontrado);
	}
	
	@Override
	public List<T> obtenerTodos(){
		List<T> copiaListadoMock = new ArrayList<T>(listadoObjetosMock);
		return copiaListadoMock;
	}

	@SuppressWarnings("unchecked")
	public T getObjetoDelListado(Long identificador) {
		T objetoEncontrado = null;
		for (T objeto : listadoObjetosMock) {
			if (objeto.getId() == identificador){
				objetoEncontrado = (T) objeto.clone();
			}
		}
		return objetoEncontrado;
	}

	public void anhadirdObjeto(T objeto) {
		listadoObjetosMock.add(objeto);
	}
}
