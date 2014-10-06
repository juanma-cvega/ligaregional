package com.jusoft.ligaregional.persistencia.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.EquipoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@ContextConfiguration(locations = RutasDeContextos.HIBERNATE)
public class EquipoDaoHibernateTest extends EquipoDaoTest{

	@Resource(name = "equipoDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Equipo, Long> equipoDao){
		this.abstractDao = equipoDao;
	}

}
