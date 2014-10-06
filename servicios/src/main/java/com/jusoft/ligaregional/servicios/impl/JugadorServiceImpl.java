package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.JugadorDao;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;
import com.jusoft.ligaregional.servicios.JugadorService;

@Service("jugadorServiceImpl")
public class JugadorServiceImpl extends AbstractServiceImpl<Jugador, Long> implements
		JugadorService {

	@Resource(name = "jugadorDaoMock")
	public void setDao(JugadorDao jugadorDao){
		this.dao = jugadorDao;
	}
}
