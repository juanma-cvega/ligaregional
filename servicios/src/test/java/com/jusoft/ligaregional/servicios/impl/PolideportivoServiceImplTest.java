package com.jusoft.ligaregional.servicios.impl;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.PolideportivoDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;
import com.jusoft.ligaregional.servicios.AbstractService;

public class PolideportivoServiceImplTest extends AbstractServiceImplTest<Polideportivo, Long> {

	@Qualifier("polideportivoServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Polideportivo, Long> polideportivoService) {
		this.service = polideportivoService;
	}
	
	@Override
	protected Polideportivo hookObjetoParaGuardar() {
		return PolideportivoDatosMock.mockPolideportivo();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Polideportivo polideportivoCargado) {
		Assert.assertNotNull(polideportivoCargado.getNombre());
		Assert.assertNotNull(polideportivoCargado.getCamposDisponibles());
		Assert.assertNotNull(polideportivoCargado.getDireccion().getCalle());
		Assert.assertNotNull(polideportivoCargado.getDireccion().getCiudad());
		Assert.assertNotNull(polideportivoCargado.getDireccion().getCodigoPostal());
		Assert.assertNotNull(polideportivoCargado.getDireccion().getProvincia());
		Assert.assertNotNull(polideportivoCargado.getPartidos());
	}

	@Override
	protected Polideportivo hookModificacionDeObjetoDePruebasParaActualizacion(Polideportivo polideportivoPruebas) {
		polideportivoPruebas.setNombre("nombre2");
		return polideportivoPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Polideportivo objetoParaActualizar, Polideportivo objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getNombre(), objetoActualizado.getNombre());
	}

	
}
