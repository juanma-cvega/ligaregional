package com.jusoft.ligaregional.persistencia.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PartidoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@ContextConfiguration(locations = RutasDeContextos.JDBC)
public class PartidoDaoJdbcTest extends PartidoDaoTest{
	@Resource(name = "partidoDaoJdbc")
	@Override
	protected void setAbstractDao(AbstractDao<Partido, Long> partidoDao){
		this.abstractDao = partidoDao;
	}
	
}
