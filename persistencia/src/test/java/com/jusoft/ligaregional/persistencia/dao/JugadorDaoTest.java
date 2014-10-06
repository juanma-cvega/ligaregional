package com.jusoft.ligaregional.persistencia.dao;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Jugador;

public abstract class JugadorDaoTest extends AbstractDaoTest<Jugador>{

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Jugador jugadorRecuperado) {
		Assert.assertNotNull(jugadorRecuperado.getPersona().getNombre());
		Assert.assertNotNull(jugadorRecuperado.getPersona().getApellido1());
		Assert.assertNotNull(jugadorRecuperado.getPersona().getApellido2());
		Assert.assertNotNull(jugadorRecuperado.getPersona().getDni());
		Assert.assertNotNull(jugadorRecuperado.getCapitan());
		Assert.assertNotNull(jugadorRecuperado.getEquipo().getId());
		Assert.assertNotNull(jugadorRecuperado.getTemporada().getId());
	}
	
	@Override
	protected Jugador hookModificacionDeObjetoParaPruebaDeActualizacion(Jugador jugadorPruebas) {
		jugadorPruebas.getPersona().setNombre("nombre2");
		return jugadorPruebas;
	}
	
}
