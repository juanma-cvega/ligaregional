package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@Repository(value = "partidoDaoJpa")
public class PartidoDaoJpa extends AbstractDaoJpa<Partido, Long> implements PartidoDao{

}
