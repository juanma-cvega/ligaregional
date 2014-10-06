package com.jusoft.ligaregional.persistencia.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.ArbitroDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@ContextConfiguration(locations = RutasDeContextos.MOCK)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class ArbitroDaoMockTest extends ArbitroDaoTest {

	@Resource(name = "arbitroDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Arbitro, Long> arbitroDao){
		this.abstractDao = arbitroDao;
	}

}
