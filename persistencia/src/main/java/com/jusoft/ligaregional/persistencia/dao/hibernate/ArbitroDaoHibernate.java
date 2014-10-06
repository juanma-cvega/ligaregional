package com.jusoft.ligaregional.persistencia.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@Repository(value = "arbitroDaoHibernate")
public class ArbitroDaoHibernate extends AbstractDaoHibernate<Arbitro, Long> implements ArbitroDao{

}
