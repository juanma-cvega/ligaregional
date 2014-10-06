package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.PolideportivoRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@Repository(value = "polideportivoDaoJdbc")
public class PolideportivoDaoJdbc extends AbstractDaoJdbc<Polideportivo, Long> implements PolideportivoDao{

	@JdbcQuery(query = "insert into Polideportivos (nombre,calle,ciudad,provincia,codigo_postal,campos_disponibles) values (:nombre,:direccion.calle,:direccion.ciudad,:direccion.provincia,:direccion.codigoPostal,:camposDisponibles)")
	@Override
	public Polideportivo guardar(Polideportivo objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = PolideportivoRowMapper.class, query = "select polideportivo_id, nombre, calle, ciudad, provincia, codigo_postal, campos_disponibles from Polideportivos where polideportivo_id = :id")
	@Override
	public Polideportivo cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Polideportivos set nombre = :nombre, calle = :direccion.calle, ciudad = :direccion.ciudad, provincia = :direccion.provincia, codigo_postal = :direccion.codigoPostal, campos_disponibles = :camposDisponibles where polideportivo_id = :id")
	@Override
	public void actualizar(Polideportivo objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Polideportivos where polideportivo_id = :id")
	@Override
	public void borrar(Polideportivo objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}

	@JdbcQuery(mapper = PolideportivoRowMapper.class, query = "select * from Polideportivos")
	@Override
	public List<Polideportivo> obtenerTodos(){
		return super.obtenerTodos();
	}

}
