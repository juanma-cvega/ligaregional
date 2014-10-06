package com.jusoft.ligaregional.persistencia.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.ArbitroDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@ContextConfiguration(locations = RutasDeContextos.HIBERNATE)
public class ArbitroDaoHibernateTest extends ArbitroDaoTest{
	
	@Resource(name = "arbitroDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Arbitro, Long> arbitroDao){
		this.abstractDao = arbitroDao;
	}
}
