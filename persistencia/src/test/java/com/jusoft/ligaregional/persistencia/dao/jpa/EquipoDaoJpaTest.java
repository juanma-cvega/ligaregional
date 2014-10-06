package com.jusoft.ligaregional.persistencia.dao.jpa;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.EquipoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@ContextConfiguration(locations = RutasDeContextos.JPA)
public class EquipoDaoJpaTest extends EquipoDaoTest {

	@Resource(name = "equipoDaoJpa")
	@Override
	protected void setAbstractDao(AbstractDao<Equipo, Long> equipoDao){
		this.abstractDao = equipoDao;
	}
	
}
