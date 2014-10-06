package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.EquipoRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@Repository(value = "equipoDaoJdbc")
public class EquipoDaoJdbc extends AbstractDaoJdbc<Equipo, Long> implements EquipoDao{

	@JdbcQuery(query = "insert into Equipos (nombre,temporada) values (:nombre,:temporada.id)")
	@Override
	public Equipo guardar(Equipo objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = EquipoRowMapper.class, query = "select equipo_id, nombre, temporada from Equipos where equipo_id = :id")
	@Override
	public Equipo cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Equipos set nombre = :nombre, temporada = :temporada.id where equipo_id = :id")
	@Override
	public void actualizar(Equipo objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Equipos where equipo_id = :id")
	@Override
	public void borrar(Equipo objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}
	
	@JdbcQuery(mapper = EquipoRowMapper.class, query = "select * from Equipos")
	@Override
	public List<Equipo> obtenerTodos(){
		return super.obtenerTodos();
	}


}
