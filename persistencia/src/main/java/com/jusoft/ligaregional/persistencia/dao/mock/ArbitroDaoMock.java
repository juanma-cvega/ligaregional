package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.ArbitroDao;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@Repository(value = "arbitroDaoMock")
public class ArbitroDaoMock extends AbstractDaoMock<Arbitro, Long> implements ArbitroDao {

}
