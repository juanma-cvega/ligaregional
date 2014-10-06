package com.jusoft.ligaregional.persistencia.dao.jpa;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.ArbitroDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@ContextConfiguration(locations = RutasDeContextos.JPA)
public class ArbitroDaoJpaTest extends ArbitroDaoTest {

	@Resource(name = "arbitroDaoJpa")
	@Override
	protected void setAbstractDao(AbstractDao<Arbitro, Long> arbitroDao){
		this.abstractDao = arbitroDao;
	}
	
}
