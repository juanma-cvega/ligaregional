package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@Repository("jugadorDaoMyBatis")
public class JugadorDaoMyBatis extends AbstractDaoMyBatis<Jugador, Long> implements JugadorDao {

	@Autowired
	public void setAbstractDaoMapper(JugadorDaoMyBatisMapper jugadorDaoMapper){
		this.abstractDaoMapper = jugadorDaoMapper;
	}
}
