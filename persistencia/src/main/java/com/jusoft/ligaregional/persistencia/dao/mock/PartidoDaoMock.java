package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PartidoDao;
import com.jusoft.ligaregional.persistencia.modelo.Partido;

@Repository(value = "partidoDaoMock")
public class PartidoDaoMock extends AbstractDaoMock<Partido, Long> implements PartidoDao {

}
