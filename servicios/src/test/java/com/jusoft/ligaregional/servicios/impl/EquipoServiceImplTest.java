package com.jusoft.ligaregional.servicios.impl;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.EquipoDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.servicios.AbstractService;

public class EquipoServiceImplTest extends AbstractServiceImplTest<Equipo, Long> {

	@Qualifier("equipoServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Equipo, Long> equipoService) {
		this.service = equipoService;
	}
	
	@Override
	protected Equipo hookObjetoParaGuardar() {
		return EquipoDatosMock.mockEquipo();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Equipo equipoCargado) {
		Assert.assertNotNull(equipoCargado.getNombre());
		Assert.assertNotNull(equipoCargado.getJugadores());
		Assert.assertNotNull(equipoCargado.getPartidosComoLocal());
		Assert.assertNotNull(equipoCargado.getPartidosComoVisitante());
		Assert.assertNotNull(equipoCargado.getTemporada());
		Assert.assertNotNull(equipoCargado.getTemporada().getId());
	}

	@Override
	protected Equipo hookModificacionDeObjetoDePruebasParaActualizacion(Equipo equipoPruebas) {
		equipoPruebas.setNombre("nombre2");
		return equipoPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Equipo objetoParaActualizar, Equipo objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getNombre(), objetoActualizado.getNombre());
	}

}
