package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusoft.ligaregional.persistencia.modelo.Direccion;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

public class PolideportivoRowMapper extends AbstractRowMapper<Polideportivo> {

	@Override
	public Polideportivo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Polideportivo polideportivo = new Polideportivo();
		polideportivo.setId(rs.getLong("polideportivo_id"));
		polideportivo.setNombre(rs.getString("nombre"));
		Direccion direccion = new Direccion();
		direccion.setCiudad(rs.getString("ciudad"));
		direccion.setCodigoPostal(rs.getString("codigo_postal"));
		direccion.setCalle(rs.getString("calle"));
		direccion.setProvincia(rs.getString("provincia"));
		polideportivo.setDireccion(direccion);
		polideportivo.setCamposDisponibles(rs.getInt("campos_disponibles"));
		return polideportivo;
	}

}
