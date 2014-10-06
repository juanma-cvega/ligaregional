package com.jusoft.ligaregional.persistencia.dao;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

public abstract class ArbitroDaoTest extends AbstractDaoTest<Arbitro>{

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Arbitro arbitroRecuperado) {
		Assert.assertNotNull(arbitroRecuperado.getPersona().getNombre());
		Assert.assertNotNull(arbitroRecuperado.getPersona().getApellido1());
		Assert.assertNotNull(arbitroRecuperado.getPersona().getDni());
		Assert.assertNotNull(arbitroRecuperado.getDireccion().getCiudad());
		Assert.assertNotNull(arbitroRecuperado.getDireccion().getCodigoPostal());
		Assert.assertNotNull(arbitroRecuperado.getDireccion().getCalle());
		Assert.assertNotNull(arbitroRecuperado.getDireccion().getProvincia());
		Assert.assertNotNull(arbitroRecuperado.getNumeroColegiado());
	}
	
	@Override
	protected Arbitro hookModificacionDeObjetoParaPruebaDeActualizacion(Arbitro arbitroPruebas) {
		arbitroPruebas.getPersona().setNombre("nombre2");
		return arbitroPruebas;
	}
	
}
