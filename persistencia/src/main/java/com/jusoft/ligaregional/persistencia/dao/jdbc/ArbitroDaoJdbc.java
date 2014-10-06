package com.jusoft.ligaregional.persistencia.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.dao.jdbc.anotaciones.JdbcQuery;
import com.jusoft.ligaregional.persistencia.dao.jdbc.mappers.ArbitroRowMapper;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@Repository(value = "arbitroDaoJdbc")
public class ArbitroDaoJdbc extends AbstractDaoJdbc<Arbitro, Long> implements ArbitroDao{

	@JdbcQuery(query = "insert into Arbitros (nombre,apellido1,apellido2,dni,calle,ciudad,provincia,codigo_postal,numero_colegiado) values (:persona.nombre,:persona.apellido1,:persona.apellido2,:persona.dni,:direccion.calle,:direccion.ciudad,:direccion.provincia,:direccion.codigoPostal,:numeroColegiado)")
	@Override
	public Arbitro guardar(Arbitro objetoParaGuardar) {
		return super.guardar(objetoParaGuardar);
	}

	@JdbcQuery(mapper = ArbitroRowMapper.class, query = "select arbitro_id, nombre, apellido1, apellido2, dni, calle, ciudad, provincia, codigo_postal, numero_colegiado from Arbitros where arbitro_id = :id")
	@Override
	public Arbitro cargar(Long identificadorObjeto) {
		return super.cargar(identificadorObjeto);
	}

	@JdbcQuery(query = "update Arbitros set nombre = :persona.nombre, apellido1 = :persona.apellido1, apellido2 = :persona.apellido2, dni = :persona.dni, calle = :direccion.calle, provincia = :direccion.provincia, ciudad = :direccion.ciudad, codigo_postal = :direccion.codigoPostal, numero_colegiado = :numeroColegiado where arbitro_id = :id")
	@Override
	public void actualizar(Arbitro objetoParaActualizar) {
		super.actualizar(objetoParaActualizar);
	}

	@JdbcQuery(query = "delete from Arbitros where arbitro_id = :id")
	@Override
	public void borrar(Arbitro objetoParaBorrar) {
		super.borrar(objetoParaBorrar);
	}
	
	@JdbcQuery(mapper = ArbitroRowMapper.class, query = "select * from Arbitros")
	@Override
	public List<Arbitro> obtenerTodos(){
		return super.obtenerTodos();
	}

}
