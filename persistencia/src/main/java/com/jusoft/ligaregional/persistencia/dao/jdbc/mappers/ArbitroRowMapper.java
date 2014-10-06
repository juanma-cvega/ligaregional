package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.persistencia.modelo.Direccion;
import com.jusoft.ligaregional.persistencia.modelo.Persona;

public class ArbitroRowMapper extends AbstractRowMapper<Arbitro>{
	
	@Override
	public Arbitro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Arbitro arbitro = new Arbitro();
		arbitro.setId(rs.getLong("arbitro_id"));
		Persona persona = new Persona();
		persona.setNombre(rs.getString("nombre"));
		persona.setApellido1(rs.getString("apellido1"));
		persona.setApellido2(rs.getString("apellido2"));
		persona.setDni(rs.getString("dni"));
		arbitro.setPersona(persona);
		Direccion direccion = new Direccion();
		direccion.setCiudad(rs.getString("ciudad"));
		direccion.setCodigoPostal(rs.getString("codigo_postal"));
		direccion.setCalle(rs.getString("calle"));
		direccion.setProvincia(rs.getString("provincia"));
		arbitro.setDireccion(direccion);
		arbitro.setNumeroColegiado(rs.getString("numero_colegiado"));
		return arbitro;
	}
}
