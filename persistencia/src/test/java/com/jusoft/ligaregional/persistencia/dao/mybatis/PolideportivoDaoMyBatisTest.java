package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PolideportivoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class PolideportivoDaoMyBatisTest extends PolideportivoDaoTest {
 
	@Resource(name = "polideportivoDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Polideportivo, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}