package com.jusoft.ligaregional.servicios.impl;

import java.sql.Timestamp;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.TemporadaDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;
import com.jusoft.ligaregional.servicios.AbstractService;

public class TemporadaServiceImplTest extends AbstractServiceImplTest<Temporada, Long> {

	@Qualifier("temporadaServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Temporada, Long> temporadaService) {
		this.service = temporadaService;
	}
	
	@Override
	protected Temporada hookObjetoParaGuardar() {
		return TemporadaDatosMock.mockTemporada();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Temporada temporadaCargado) {
		Assert.assertNotNull(temporadaCargado.getEquipos());
		Assert.assertNotNull(temporadaCargado.getFechaFin());
		Assert.assertNotNull(temporadaCargado.getFechaInicio());
		Assert.assertNotNull(temporadaCargado.getJugadores());
		Assert.assertNotNull(temporadaCargado.getPartidos());
	}

	@Override
	protected Temporada hookModificacionDeObjetoDePruebasParaActualizacion(Temporada temporadaPruebas) {
		temporadaPruebas.setFechaFin(new Timestamp(32452345L));
		return temporadaPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Temporada objetoParaActualizar, Temporada objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getFechaFin(), objetoActualizado.getFechaFin());
	}

	
}
