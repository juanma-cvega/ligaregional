package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@Repository(value = "arbitroDaoJpa")
public class ArbitroDaoJpa extends AbstractDaoJpa<Arbitro, Long> implements ArbitroDao{

}
