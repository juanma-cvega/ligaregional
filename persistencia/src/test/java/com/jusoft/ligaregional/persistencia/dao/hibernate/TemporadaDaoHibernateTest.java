package com.jusoft.ligaregional.persistencia.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.TemporadaDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@ContextConfiguration(locations = RutasDeContextos.HIBERNATE)
public class TemporadaDaoHibernateTest extends TemporadaDaoTest{

	@Resource(name = "temporadaDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Temporada, Long> temporadaDao){
		this.abstractDao = temporadaDao;
	}

}
