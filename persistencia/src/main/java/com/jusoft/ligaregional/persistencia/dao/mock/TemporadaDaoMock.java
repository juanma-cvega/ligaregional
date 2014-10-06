package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.TemporadaDao;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

@Repository(value = "temporadaDaoMock")
public class TemporadaDaoMock extends AbstractDaoMock<Temporada, Long> implements TemporadaDao {

}
