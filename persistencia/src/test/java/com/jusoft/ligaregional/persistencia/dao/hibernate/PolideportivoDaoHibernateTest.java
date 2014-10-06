package com.jusoft.ligaregional.persistencia.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PolideportivoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@ContextConfiguration(locations = RutasDeContextos.HIBERNATE)
public class PolideportivoDaoHibernateTest extends PolideportivoDaoTest{

	@Resource(name = "polideportivoDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Polideportivo, Long> polideportivoDao){
		this.abstractDao = polideportivoDao;
	}
}
