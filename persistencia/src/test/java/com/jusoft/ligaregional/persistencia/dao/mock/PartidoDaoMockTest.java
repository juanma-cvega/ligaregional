package com.jusoft.ligaregional.persistencia.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PartidoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@ContextConfiguration(locations = RutasDeContextos.MOCK)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class PartidoDaoMockTest extends PartidoDaoTest {

	@Resource(name = "partidoDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Partido, Long> partidoDao){
		this.abstractDao = partidoDao;
	}

}
