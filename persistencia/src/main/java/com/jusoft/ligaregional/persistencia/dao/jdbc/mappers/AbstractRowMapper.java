package com.jusoft.ligaregional.persistencia.dao.jdbc.mappers;

import org.springframework.jdbc.core.RowMapper;

import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;

public abstract class AbstractRowMapper<T extends AbstractModelo<Long>> implements RowMapper<T>{

}
