package com.jusoft.ligaregional.persistencia.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.EquipoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@ContextConfiguration(locations = RutasDeContextos.MOCK)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class EquipoDaoMockTest extends EquipoDaoTest{

	@Resource(name = "equipoDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Equipo, Long> equipoDao) {
		this.abstractDao = equipoDao;
	}

}
