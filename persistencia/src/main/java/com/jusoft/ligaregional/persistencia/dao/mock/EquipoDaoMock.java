package com.jusoft.ligaregional.persistencia.dao.mock;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@Repository(value = "equipoDaoMock")
public class EquipoDaoMock extends AbstractDaoMock<Equipo, Long> implements EquipoDao {

}
