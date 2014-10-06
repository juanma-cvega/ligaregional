package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.PolideportivoDao;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

@Repository(value = "polideportivoDaoMock")
public class PolideportivoDaoMock extends AbstractDaoMock<Polideportivo, Long> implements PolideportivoDao {

}
