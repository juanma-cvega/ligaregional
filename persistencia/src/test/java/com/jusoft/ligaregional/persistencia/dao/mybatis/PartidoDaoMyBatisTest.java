package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PartidoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class PartidoDaoMyBatisTest extends PartidoDaoTest {

	@Resource(name = "partidoDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Partido, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}
