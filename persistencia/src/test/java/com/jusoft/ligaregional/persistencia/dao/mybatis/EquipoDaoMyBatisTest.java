package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.EquipoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class EquipoDaoMyBatisTest extends EquipoDaoTest {

	@Resource(name = "equipoDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Equipo, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}
