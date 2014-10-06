package com.jusoft.ligaregional.persistencia.dao.jpa;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.PolideportivoDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@ContextConfiguration(locations = RutasDeContextos.JPA)
public class PolideportivoDaoJpaTest extends PolideportivoDaoTest {

	@Resource(name = "polideportivoDaoJpa")
	@Override
	protected void setAbstractDao(AbstractDao<Polideportivo, Long> polideportivoDao){
		this.abstractDao = polideportivoDao;
	}
}
