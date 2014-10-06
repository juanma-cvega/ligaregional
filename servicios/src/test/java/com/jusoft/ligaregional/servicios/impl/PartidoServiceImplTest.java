package com.jusoft.ligaregional.servicios.impl;

import java.sql.Timestamp;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.PartidoDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Partido;
import com.jusoft.ligaregional.servicios.AbstractService;

public class PartidoServiceImplTest extends AbstractServiceImplTest<Partido, Long> {

	@Qualifier("partidoServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Partido, Long> partidoService) {
		this.service = partidoService;
	}
	
	@Override
	protected Partido hookObjetoParaGuardar() {
		return PartidoDatosMock.mockPartido();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Partido partidoCargado) {
		Assert.assertNotNull(partidoCargado.getArbitro().getId());
		Assert.assertNotNull(partidoCargado.getFecha());
		Assert.assertNotNull(partidoCargado.getLocal().getId());
		Assert.assertNotNull(partidoCargado.getVisitante().getId());
		Assert.assertNotNull(partidoCargado.getPolideportivo().getId());
		Assert.assertNotNull(partidoCargado.getTemporada().getId());
	}

	@Override
	protected Partido hookModificacionDeObjetoDePruebasParaActualizacion(Partido partidoPruebas) {
		partidoPruebas.setFecha(new Timestamp(234342342L));
		return partidoPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Partido objetoParaActualizar, Partido objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getFecha(), objetoActualizado.getFecha());
	}

	
}
