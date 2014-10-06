package com.jusoft.ligaregional.persistencia.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PolideportivoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@ContextConfiguration(locations = RutasDeContextos.MOCK)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class PolideportivoDaoMockTest extends PolideportivoDaoTest {

	@Resource(name = "polideportivoDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Polideportivo, Long> polideportivoDao){
		this.abstractDao = polideportivoDao;
	}
}
