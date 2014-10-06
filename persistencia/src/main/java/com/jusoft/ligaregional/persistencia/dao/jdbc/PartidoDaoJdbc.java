package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.PartidoRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@Repository(value = "partidoDaoJdbc")
public class PartidoDaoJdbc extends AbstractDaoJdbc<Partido, Long> implements PartidoDao{

	@JdbcQuery(query = "insert into Partidos (temporada,fecha,local,visitante,arbitro,polideportivo) values (:temporada.id,:fecha,:local.id,:visitante.id,:arbitro.id,:polideportivo.id)")
	@Override
	public Partido guardar(Partido objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = PartidoRowMapper.class, query = "select partido_id, temporada, fecha, local, visitante, arbitro, polideportivo from Partidos where partido_id = :id")
	@Override
	public Partido cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Partidos set temporada = :temporada.id, fecha = :fecha, local = :local.id, visitante = :visitante.id, arbitro = :arbitro.id, polideportivo = :polideportivo.id where partido_id = :id")
	@Override
	public void actualizar(Partido objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Partidos where partido_id = :id")
	@Override
	public void borrar(Partido objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}

	@JdbcQuery(mapper = PartidoRowMapper.class, query = "select * from Partidos")
	@Override
	public List<Partido> obtenerTodos(){
		return super.obtenerTodos();
	}

}
