package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;
import com.jusoft.ligaregional.servicios.TemporadaService;

@Service("temporadaServiceImpl")
public class TemporadaServiceImpl extends AbstractServiceImpl<Temporada, Long> implements
		TemporadaService {

	@Resource(name = "temporadaDaoMock")
	public void setDao(TemporadaDao temporadaDao){
		this.dao = temporadaDao;
	}
}
