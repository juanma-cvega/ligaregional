package com.jusoft.ligaregional.persistencia.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.TemporadaDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@ContextConfiguration(locations = RutasDeContextos.JDBC)
public class TemporadaDaoJdbcTest extends TemporadaDaoTest{

	@Resource(name = "temporadaDaoJdbc")
	@Override
	protected void setAbstractDao(AbstractDao<Temporada, Long> temporadaDao){
		this.abstractDao = temporadaDao;
	}
}
