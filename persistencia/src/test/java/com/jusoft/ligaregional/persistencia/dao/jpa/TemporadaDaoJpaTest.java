package com.jusoft.ligaregional.persistencia.dao.jpa;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.TemporadaDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@ContextConfiguration(locations = RutasDeContextos.JPA)
public class TemporadaDaoJpaTest extends TemporadaDaoTest {

	@Resource(name = "temporadaDaoJpa")
	@Override
	protected void setAbstractDao(AbstractDao<Temporada, Long>temporadaDao){
		this.abstractDao = temporadaDao;
	}
	
}
