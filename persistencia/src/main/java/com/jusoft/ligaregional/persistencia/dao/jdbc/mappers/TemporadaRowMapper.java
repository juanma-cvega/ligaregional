package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class TemporadaRowMapper extends AbstractRowMapper<Temporada> {

	@Override
	public Temporada mapRow(ResultSet rs, int rowNum) throws SQLException {
		Temporada temporada = new Temporada();
		temporada.setId(rs.getLong("temporada_id"));
		temporada.setFechaFin(new Date(rs.getDate("fecha_fin").getTime()));
		temporada.setFechaInicio(new Date(rs.getDate("fecha_inicio").getTime()));
		return temporada;
	}

}
