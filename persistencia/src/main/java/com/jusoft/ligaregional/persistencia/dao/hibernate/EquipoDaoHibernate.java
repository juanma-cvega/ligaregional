package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@Repository(value = "equipoDaoHibernate")
public class EquipoDaoHibernate extends AbstractDaoHibernate<Equipo, Long> implements EquipoDao{

}
