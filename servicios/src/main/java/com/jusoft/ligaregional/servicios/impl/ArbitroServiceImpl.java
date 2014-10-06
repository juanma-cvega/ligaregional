package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.servicios.ArbitroService;

@Service("arbitroServiceImpl")
public class ArbitroServiceImpl extends AbstractServiceImpl<Arbitro, Long> implements ArbitroService{

	@Resource(name = "arbitroDaoMock")
	public void setDao(ArbitroDao arbitroDao){
		this.dao = arbitroDao;
	}

}
