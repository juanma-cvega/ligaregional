package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Partido;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class PartidoRowMapper extends AbstractRowMapper<Partido> {

	@Override
	public Partido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Partido partido = new Partido();
		partido.setId(rs.getLong("partido_id"));
		Arbitro arbitro = new Arbitro();
		arbitro.setId(rs.getLong("arbitro"));
		partido.setArbitro(arbitro);
		partido.setFecha(rs.getTimestamp("fecha"));
		Equipo local = new Equipo();
		local.setId(rs.getLong("local"));
		partido.setLocal(local);
		Polideportivo polideportivo = new Polideportivo();
		polideportivo.setId(rs.getLong("polideportivo"));
		partido.setPolideportivo(polideportivo);
		Temporada temporada = new Temporada();
		temporada.setId(rs.getLong("temporada"));
		partido.setTemporada(temporada);
		Equipo visitante = new Equipo();
		visitante.setId(rs.getLong("visitante"));
		partido.setVisitante(visitante);
		return partido;
	}

}
