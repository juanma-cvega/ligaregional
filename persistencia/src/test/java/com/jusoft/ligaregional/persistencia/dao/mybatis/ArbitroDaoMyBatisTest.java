package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.ArbitroDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class ArbitroDaoMyBatisTest extends ArbitroDaoTest {

	@Resource(name = "arbitroDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Arbitro, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}
