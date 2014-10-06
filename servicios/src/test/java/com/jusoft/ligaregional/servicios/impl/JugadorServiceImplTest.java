package com.jusoft.ligaregional.servicios.impl;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.JugadorDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;
import com.jusoft.ligaregional.servicios.AbstractService;

public class JugadorServiceImplTest extends AbstractServiceImplTest<Jugador, Long> {

	@Qualifier("jugadorServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Jugador, Long> jugadorService) {
		this.service = jugadorService;
	}
	
	@Override
	protected Jugador hookObjetoParaGuardar() {
		return JugadorDatosMock.mockJugador();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Jugador jugadorCargado) {
		Assert.assertNotNull(jugadorCargado.getPersona().getNombre());
		Assert.assertNotNull(jugadorCargado.getPersona().getApellido1());
		Assert.assertNotNull(jugadorCargado.getPersona().getApellido2());
		Assert.assertNotNull(jugadorCargado.getPersona().getDni());
		Assert.assertNotNull(jugadorCargado.getEquipo().getId());
		Assert.assertNotNull(jugadorCargado.getTemporada().getId());
	}

	@Override
	protected Jugador hookModificacionDeObjetoDePruebasParaActualizacion(Jugador jugadorPruebas) {
		jugadorPruebas.getPersona().setNombre("nombre2");
		return jugadorPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Jugador objetoParaActualizar, Jugador objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getPersona().getNombre(), objetoActualizado.getPersona().getNombre());
	}

	
}
