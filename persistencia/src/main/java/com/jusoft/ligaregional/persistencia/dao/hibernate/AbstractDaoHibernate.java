package com.jusoft.ligaregional.persistencia.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;

public abstract class AbstractDaoHibernate <T, ID extends Serializable> implements AbstractDao<T, ID>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clasePersistida;

	@SuppressWarnings("unchecked")
	public AbstractDaoHibernate(){
		this.clasePersistida = (Class<T>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T guardar(T objetoParaGuardar) {
		getSession().saveOrUpdate(objetoParaGuardar);
		return objetoParaGuardar;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T cargar(ID identificador) {
		return (T)getSession().get(clasePersistida,identificador);
	}
	
	@Override
	public void actualizar(T objetoParaActualizar){
		getSession().update(objetoParaActualizar);
	}
	
	@Override
	public void borrar(T objetoParaBorrar){
		getSession().delete(objetoParaBorrar);
	}
	
	@Override
	public void borrar(ID identificadorObjeto){
		T objetoParaBorrar = cargar(identificadorObjeto);
		getSession().delete(objetoParaBorrar);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos(){
		return getSession().createCriteria(clasePersistida).list();
	}

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
