package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;

@Repository(value = "jugadorDaoMock")
public class JugadorDaoMock extends AbstractDaoMock<Jugador, Long>implements JugadorDao{


}
