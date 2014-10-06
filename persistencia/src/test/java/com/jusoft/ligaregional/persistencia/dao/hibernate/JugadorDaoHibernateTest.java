package com.jusoft.ligaregional.persistencia.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.JugadorDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@ContextConfiguration(locations = RutasDeContextos.HIBERNATE)
public class JugadorDaoHibernateTest extends JugadorDaoTest{

	@Resource(name = "jugadorDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Jugador, Long> jugadorDao){
		this.abstractDao = jugadorDao;
	}

}
