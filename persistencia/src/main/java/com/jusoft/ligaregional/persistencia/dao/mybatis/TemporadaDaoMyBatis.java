package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@Repository("temporadaDaoMyBatis")
public class TemporadaDaoMyBatis extends AbstractDaoMyBatis<Temporada, Long> implements TemporadaDao {

	@Autowired
	public void setAbstractDaoMapper(TemporadaDaoMyBatisMapper temporadaDaoMapper){
		this.abstractDaoMapper = temporadaDaoMapper;
	}
}
 