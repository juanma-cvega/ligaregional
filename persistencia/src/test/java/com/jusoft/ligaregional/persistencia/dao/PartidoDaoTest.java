package com.jusoft.ligaregional.persistencia.dao;

import java.util.Date;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Partido;
import com.jusoft.ligaregional.persistencia.utils.DateUtils;

public abstract class PartidoDaoTest extends AbstractDaoTest<Partido>{

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Partido partidoRecuperado) {
		Assert.assertNotNull(partidoRecuperado.getArbitro().getId());
		Assert.assertNotNull(partidoRecuperado.getFecha());
		Assert.assertNotNull(partidoRecuperado.getLocal().getId());
		Assert.assertNotNull(partidoRecuperado.getPolideportivo().getId());
		Assert.assertNotNull(partidoRecuperado.getTemporada().getId());
		Assert.assertNotNull(partidoRecuperado.getVisitante().getId());
	}
	
	@Override
	protected Partido hookModificacionDeObjetoParaPruebaDeActualizacion(Partido partidoPruebas) {
		Date fecha = DateUtils.parseoDateConFormato(DateUtils.DEFAULT_DATETIME, "1999/07/07 12:12:12");
		partidoPruebas.setFecha(fecha);
		return partidoPruebas;
	}
	
}
