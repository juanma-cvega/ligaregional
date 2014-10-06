package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@Repository("arbitroDaoMyBatis")
public class ArbitroDaoMyBatis extends AbstractDaoMyBatis<Arbitro, Long> implements
		ArbitroDao {

	@Autowired
	public void setAbstractDaoMapper(ArbitroDaoMyBatisMapper arbitroDaoMapper){
		this.abstractDaoMapper = arbitroDaoMapper;
	}
}
