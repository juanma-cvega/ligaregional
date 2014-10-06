package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;
import com.jusoft.ligaregional.servicios.PolideportivoService;

@Service("polideportivoServiceImpl")
public class PolideportivoServiceImpl extends AbstractServiceImpl<Polideportivo, Long>
		implements PolideportivoService {

	@Resource(name = "polideportivoDaoMock")
	public void setDao(PolideportivoDao polideportivoDao){
		this.dao = polideportivoDao;
	}
}
