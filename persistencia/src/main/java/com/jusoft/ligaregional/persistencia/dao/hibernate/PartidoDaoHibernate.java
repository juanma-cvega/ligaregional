package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@Repository(value = "partidoDaoHibernate")
public class PartidoDaoHibernate extends AbstractDaoHibernate<Partido, Long> implements PartidoDao{

}
