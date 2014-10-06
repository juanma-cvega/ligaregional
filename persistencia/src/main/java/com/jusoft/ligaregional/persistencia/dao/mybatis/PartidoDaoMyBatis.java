package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@Repository("partidoDaoMyBatis")
public class PartidoDaoMyBatis extends AbstractDaoMyBatis<Partido, Long> implements PartidoDao {

	@Autowired
	public void setAbstractDaoMapper(PartidoDaoMyBatisMapper partidoDaoMapper){
		this.abstractDaoMapper = partidoDaoMapper;
	}
}
