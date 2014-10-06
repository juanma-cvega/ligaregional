package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.TemporadaDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class TemporadaDaoMyBatisTest extends TemporadaDaoTest {
 
	@Resource(name = "temporadaDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Temporada, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}