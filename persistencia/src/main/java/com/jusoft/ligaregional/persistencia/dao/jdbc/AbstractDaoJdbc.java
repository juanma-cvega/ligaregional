package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.lang.reflect.Method;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.AbstractRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;
import com.jusoft.ligaregional.persistencia.utils.RelanzadorExcepciones;

public abstract class AbstractDaoJdbc<T extends AbstractModelo<Long>, ID> implements AbstractDao<T, Long> {

	protected NamedParameterJdbcOperations template;
	
	@Qualifier("dataSource")
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public T guardar(T objetoParaGuardar) {
		JdbcQuery anotacion = getAnotacion();
		SqlParameterSource parametros = new BeanPropertySqlParameterSource(objetoParaGuardar);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.template.update(anotacion.query(), parametros, keyHolder);
		long idObjetoGuardado = keyHolder.getKey().longValue();
		objetoParaGuardar.setId(idObjetoGuardado);
		return objetoParaGuardar;
	}

	@Override
	public T cargar(Long identificadorObjeto) {
		JdbcQuery anotacion = getAnotacion();
		AbstractRowMapper<T> mapper = getMapper(anotacion);
		SqlParameterSource parametros = new MapSqlParameterSource("id", identificadorObjeto);
		List<T> listadoArbitros = (List<T>) this.template.query(anotacion.query(), parametros, mapper);
		if (listadoArbitros.size() > 0) {
			return (T) listadoArbitros.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private AbstractRowMapper<T> getMapper(JdbcQuery anotacion) {
		Class<?> mapper = anotacion.mapper();
		AbstractRowMapper<T> instanciaMapper = null;
		try {
			instanciaMapper = (AbstractRowMapper<T>)mapper.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			RelanzadorExcepciones.lanzar(e1);
		}
		return instanciaMapper;
	}

	@Override
	public void actualizar(T objetoParaActualizar) {
		JdbcQuery anotacion = getAnotacion();
		SqlParameterSource parametros = new BeanPropertySqlParameterSource(objetoParaActualizar);
		this.template.update(anotacion.query(), parametros);
	}

	@Override
	public void borrar(T objetoParaBorrar) {
		borrar(objetoParaBorrar.getId());
	}
	
	@Override
	public void borrar(Long identificadorObjeto) {
		JdbcQuery anotacion = getAnotacion();
		SqlParameterSource parametros = new MapSqlParameterSource("id", identificadorObjeto);
		this.template.update(anotacion.query(), parametros);
	}

	@Override
	public List<T> obtenerTodos(){
		JdbcQuery anotacion = getAnotacion();
		AbstractRowMapper<T> mapper = getMapper(anotacion);
		SqlParameterSource parametros = new MapSqlParameterSource();
		return (List<T>) this.template.query(anotacion.query(), parametros, mapper);
	}
	
	private JdbcQuery getAnotacion() {
		String nombreMetodo = Thread.currentThread().getStackTrace()[2].getMethodName();
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(nombreMetodo) && method.isAnnotationPresent(JdbcQuery.class)){
				return method.getAnnotation(JdbcQuery.class);
			}
		}
		return null;
	}
}
