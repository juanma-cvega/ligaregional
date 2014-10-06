package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@Repository(value = "polideportivoDaoJpa")
public class PolideportivoDaoJpa extends AbstractDaoJpa<Polideportivo, Long> implements PolideportivoDao{

}
