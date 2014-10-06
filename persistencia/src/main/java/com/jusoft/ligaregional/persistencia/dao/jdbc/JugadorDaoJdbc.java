package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.JugadorRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@Repository(value = "jugadorDaoJdbc")
public class JugadorDaoJdbc extends AbstractDaoJdbc<Jugador, Long> implements JugadorDao{

	@JdbcQuery(query = "insert into Jugadores (nombre,apellido1,apellido2,dni,equipo,temporada,capitan) values (:persona.nombre,:persona.apellido1,:persona.apellido2,:persona.dni,:equipo.id,:temporada.id,:capitan)")
	@Override
	public Jugador guardar(Jugador objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = JugadorRowMapper.class, query = "select jugador_id, nombre, apellido1, apellido2, dni, equipo, temporada, capitan from Jugadores where jugador_id = :id")
	@Override
	public Jugador cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Jugadores set nombre = :persona.nombre, apellido1 = :persona.apellido1, apellido2 = :persona.apellido2, dni = :persona.dni, equipo = :equipo.id, temporada = :temporada.id, capitan = :capitan where jugador_id = :id")
	@Override
	public void actualizar(Jugador objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Jugadores where jugador_id = :id")
	@Override
	public void borrar(Jugador objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}

	@JdbcQuery(mapper = JugadorRowMapper.class, query = "select * from Jugadores")
	@Override
	public List<Jugador> obtenerTodos(){
		return super.obtenerTodos();
	}

}
