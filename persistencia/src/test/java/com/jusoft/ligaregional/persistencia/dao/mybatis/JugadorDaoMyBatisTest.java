package com.jusoft.ligaregional.persistencia.dao.mybatis;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.jusoft.ligaregional.persistencia.dao.AbstractDao;
import com.jusoft.ligaregional.persistencia.dao.JugadorDaoTest;
import com.jusoft.ligaregional.persistencia.dao.constantes.RutasDeContextos;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@ContextConfiguration(locations = RutasDeContextos.MYBATIS)
public class JugadorDaoMyBatisTest extends JugadorDaoTest {

	@Resource(name = "jugadorDaoMyBatis")
	@Override
	protected void setAbstractDao(AbstractDao<Jugador, Long> abstractDao) {
		super.setAbstractDao(abstractDao);
	}
}
