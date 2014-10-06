package com.jusoft.ligaregional.persistencia.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.ArbitroDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@ContextConfiguration(locations = RutasDeContextos.JDBC)
public class ArbitroDaoJdbcTest extends ArbitroDaoTest {

	@Override
	@Resource(name="arbitroDaoJdbc")
	protected void setAbstractDao(AbstractDao<Arbitro, Long> arbitroDao){
		this.abstractDao = arbitroDao;
	}

}
