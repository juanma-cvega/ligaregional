package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;
import com.jusoft.ligaregional.persistencia.modelo.Persona;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class JugadorRowMapper extends AbstractRowMapper<Jugador> {

	@Override
	public Jugador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Jugador jugador = new Jugador();
		jugador.setId(rs.getLong("jugador_id"));
		Persona persona = new Persona();
		persona.setNombre(rs.getString("nombre"));
		persona.setApellido1(rs.getString("apellido1"));
		persona.setApellido2(rs.getString("apellido2"));
		persona.setDni(rs.getString("dni"));
		jugador.setPersona(persona);
		jugador.setCapitan(rs.getBoolean("capitan"));
		Equipo equipo = new Equipo();
		equipo.setId(rs.getLong("equipo"));
		jugador.setEquipo(equipo);
		Temporada temporada = new Temporada();
		temporada.setId(rs.getLong("temporada"));
		jugador.setTemporada(temporada);
		return jugador;
	}

}
