package com.jusoft.ligaregional.persistencia.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PolideportivoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@ContextConfiguration(locations = RutasDeContextos.JDBC)
public class PolideportivoDaoJdbcTest extends PolideportivoDaoTest{

	@Resource(name = "polideportivoDaoJdbc")
	@Override
	protected void setAbstractDao(AbstractDao<Polideportivo, Long> polideportivoDao){
		this.abstractDao = polideportivoDao;
	}

}
