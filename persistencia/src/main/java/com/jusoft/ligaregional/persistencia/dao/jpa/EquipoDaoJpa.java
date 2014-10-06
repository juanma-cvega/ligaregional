package com.jusoft.ligaregional.persistencia.dao.jpa;

import org.springframework.stereotype.Repository;

import com.jusoft.ligaregional.persistencia.dao.EquipoDao;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;

@Repository(value = "equipoDaoJpa")
public class EquipoDaoJpa extends AbstractDaoJpa<Equipo, Long> implements EquipoDao{

}
