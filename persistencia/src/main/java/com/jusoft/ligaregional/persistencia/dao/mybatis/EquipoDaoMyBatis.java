package com.jusoft.ligaregional.persistencia.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@Repository("equipoDaoMyBatis")
public class EquipoDaoMyBatis extends AbstractDaoMyBatis<Equipo, Long> implements EquipoDao {

	@Autowired
	public void setAbstractDaoMapper(EquipoDaoMyBatisMapper equipoDaoMapper){
		this.abstractDaoMapper = equipoDaoMapper;
	}
}
