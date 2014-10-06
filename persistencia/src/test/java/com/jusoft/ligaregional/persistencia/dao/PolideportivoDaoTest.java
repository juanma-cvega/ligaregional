package com.jusoft.ligaregional.persistencia.dao;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

public abstract class PolideportivoDaoTest extends AbstractDaoTest<Polideportivo>{

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Polideportivo polideportivoRecuperado) {
		Assert.assertNotNull(polideportivoRecuperado.getNombre());
		Assert.assertNotNull(polideportivoRecuperado.getDireccion().getCiudad());
		Assert.assertNotNull(polideportivoRecuperado.getDireccion().getCodigoPostal());
		Assert.assertNotNull(polideportivoRecuperado.getDireccion().getCalle());
		Assert.assertNotNull(polideportivoRecuperado.getDireccion().getProvincia());
		Assert.assertNotNull(polideportivoRecuperado.getCamposDisponibles());
	}
	
	@Override
	protected Polideportivo hookModificacionDeObjetoParaPruebaDeActualizacion(Polideportivo polideportivoPruebas) {
		polideportivoPruebas.setNombre("nombre2");
		return polideportivoPruebas;
	}
	
}
