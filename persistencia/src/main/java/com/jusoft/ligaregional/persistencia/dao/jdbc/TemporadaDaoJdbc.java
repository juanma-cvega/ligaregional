package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.TemporadaRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@Repository(value = "temporadaDaoJdbc")
public class TemporadaDaoJdbc extends AbstractDaoJdbc<Temporada, Long> implements TemporadaDao{

	@JdbcQuery(query = "insert into Temporadas (fecha_inicio,fecha_fin) values (:fechaInicio,:fechaFin)")
	@Override
	public Temporada guardar(Temporada objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = TemporadaRowMapper.class, query = "select temporada_id, fecha_inicio, fecha_fin from Temporadas where temporada_id = :id")
	@Override
	public Temporada cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Temporadas set fecha_inicio = :fechaInicio, fecha_fin = :fechaFin where temporada_id = :id")
	@Override
	public void actualizar(Temporada objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Temporadas where temporada_id = :id")
	@Override
	public void borrar(Temporada objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}

	@JdbcQuery(mapper = TemporadaRowMapper.class, query = "select * from Temporadas")
	@Override
	public List<Temporada> obtenerTodos(){
		return super.obtenerTodos();
	}

}
