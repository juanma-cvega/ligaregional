package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.modelo.Partido;
import com.jusoft.ligaregional.servicios.PartidoService;

@Service("partidoServiceImpl")
public class PartidoServiceImpl extends AbstractServiceImpl<Partido, Long> implements
		PartidoService {

	@Resource(name = "partidoDaoMock")
	public void setDao(PartidoDao partidoDao){
		this.dao = partidoDao;
	}
}
