package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@Repository(value = "temporadaDaoHibernate")
public class TemporadaDaoHibernate extends AbstractDaoHibernate<Temporada, Long> implements TemporadaDao{

}
