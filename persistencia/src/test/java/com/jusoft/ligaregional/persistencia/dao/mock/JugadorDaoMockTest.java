package com.jusoft.ligaregional.persistencia.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.JugadorDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@ContextConfiguration(locations = RutasDeContextos.MOCK)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class JugadorDaoMockTest extends JugadorDaoTest {

	@Resource(name = "jugadorDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Jugador, Long> jugadorDao){
		this.abstractDao = jugadorDao;
	}

}