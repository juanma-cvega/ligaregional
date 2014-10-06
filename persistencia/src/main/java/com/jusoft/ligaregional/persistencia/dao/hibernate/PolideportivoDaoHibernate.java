package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@Repository(value = "polideportivoDaoHibernate")
public class PolideportivoDaoHibernate extends AbstractDaoHibernate<Polideportivo, Long> implements PolideportivoDao{

}
