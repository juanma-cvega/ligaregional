package com.jusoft.ligaregional.persistencia.dao;

import java.util.Date;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Temporada;
import com.jusoft.ligaregional.persistencia.utils.DateUtils;

public abstract class TemporadaDaoTest extends AbstractDaoTest<Temporada>{

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Temporada temporadaRecuperado) {
		Assert.assertNotNull(temporadaRecuperado.getFechaFin());
		Assert.assertNotNull(temporadaRecuperado.getFechaInicio());
	}
	
	@Override
	protected Temporada hookModificacionDeObjetoParaPruebaDeActualizacion(Temporada temporadaPruebas) {
		Date fecha = DateUtils.parseoDateConFormato("1999/03/03");
		temporadaPruebas.setFechaFin(fecha);
		return temporadaPruebas;
	}
	
}
