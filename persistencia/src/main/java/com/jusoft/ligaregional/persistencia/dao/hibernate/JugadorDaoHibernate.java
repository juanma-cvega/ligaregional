package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@Repository(value = "jugadorDaoHibernate")
public class JugadorDaoHibernate extends AbstractDaoHibernate<Jugador, Long> implements JugadorDao{

}
