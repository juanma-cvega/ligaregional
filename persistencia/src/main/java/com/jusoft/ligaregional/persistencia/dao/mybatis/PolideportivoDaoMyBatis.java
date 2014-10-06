package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@Repository("polideportivoDaoMyBatis")
public class PolideportivoDaoMyBatis extends AbstractDaoMyBatis<Polideportivo, Long> implements PolideportivoDao {

	@Autowired
	public void setAbstractDaoMapper(PolideportivoDaoMyBatisMapper polideportivoDaoMapper){
		this.abstractDaoMapper = polideportivoDaoMapper;
	}
}
