package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class EquipoRowMapper extends AbstractRowMapper<Equipo> {

	@Override
	public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Equipo equipo = new Equipo();
		equipo.setId(rs.getLong("equipo_id"));
		equipo.setNombre(rs.getString("nombre"));
		Temporada temporada = new Temporada();
		temporada.setId(rs.getLong("temporada"));
		equipo.setTemporada(temporada);
		return equipo;
	}

}
