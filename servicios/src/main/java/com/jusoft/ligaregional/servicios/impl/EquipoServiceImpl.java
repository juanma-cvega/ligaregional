package com.jusoft.ligaregional.servicios.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.servicios.EquipoService;

@Service("equipoServiceImpl")
public class EquipoServiceImpl extends AbstractServiceImpl<Equipo, Long> implements
		EquipoService {

	@Resource(name = "equipoDaoMock")
	public void setDao(EquipoDao equipoDao){
		this.dao = equipoDao;
	}
}
