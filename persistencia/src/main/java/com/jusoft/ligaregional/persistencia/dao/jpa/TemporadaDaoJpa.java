package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@Repository(value = "temporadaDaoJpa")
public class TemporadaDaoJpa extends AbstractDaoJpa<Temporada, Long> implements TemporadaDao{

}
