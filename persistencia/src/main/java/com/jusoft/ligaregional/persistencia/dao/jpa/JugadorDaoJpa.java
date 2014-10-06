package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@Repository(value = "jugadorDaoJpa")
public class JugadorDaoJpa extends AbstractDaoJpa<Jugador, Long> implements JugadorDao{

}
