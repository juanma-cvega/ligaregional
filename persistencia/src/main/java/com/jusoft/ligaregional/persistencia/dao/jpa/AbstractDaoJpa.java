package com.jusoft.ligaregional.persistencia.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;

public abstract class AbstractDaoJpa<T extends AbstractModelo<ID>, ID extends Serializable> implements AbstractDao<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;
	
	protected Class<T> clasePersistida;

	@SuppressWarnings("unchecked")
	public AbstractDaoJpa(){
		this.clasePersistida = (Class<T>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T guardar(T objetoParaGuardar) {
		getEntityManager().persist(objetoParaGuardar);
		getEntityManager().flush();
		return objetoParaGuardar;
	}

	@Override
	public T cargar(ID identificadorObjeto) {
		return getEntityManager().find(clasePersistida, identificadorObjeto);
	}

	@Override
	public void actualizar(T objetoParaActualizar) {
		getEntityManager().merge(objetoParaActualizar);
	}

	@Override
	public void borrar(T objetoParaBorrar) {
		getEntityManager().remove(objetoParaBorrar);
	}
	
	@Override
	public void borrar(ID identificadorObjeto){
		T objetoParaBorrar = getEntityManager().find(clasePersistida, identificadorObjeto);
		getEntityManager().remove(objetoParaBorrar);
	}
	
	@Override
	public List<T> obtenerTodos(){
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> query = builder.createQuery(clasePersistida);
	    Root<T> variableRoot = query.from(clasePersistida);
	    query.select(variableRoot);

	    return getEntityManager().createQuery(query).getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
