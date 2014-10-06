package com.jusoft.ligaregional.servicios.impl;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jusoft.ligaregional.persistencia.dao.datosmock.ArbitroDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.servicios.AbstractService;

public class ArbitroServiceImplTest extends AbstractServiceImplTest<Arbitro, Long> {

	@Qualifier("arbitroServiceImpl")
	@Autowired
	@Override
	public void setService(AbstractService<Arbitro, Long> arbitroService) {
		this.service = arbitroService;
	}
	
	@Override
	protected Arbitro hookObjetoParaGuardar() {
		return ArbitroDatosMock.mockArbitro();
	}

	@Override
	protected void hookComprobacionObjetoCargadoConDatos(Arbitro arbitroCargado) {
		Assert.assertNotNull(arbitroCargado.getNumeroColegiado());
		Assert.assertNotNull(arbitroCargado.getDireccion().getCalle());
		Assert.assertNotNull(arbitroCargado.getDireccion().getCiudad());
		Assert.assertNotNull(arbitroCargado.getDireccion().getCodigoPostal());
		Assert.assertNotNull(arbitroCargado.getDireccion().getProvincia());
		Assert.assertNotNull(arbitroCargado.getPartidos());
		Assert.assertNotNull(arbitroCargado.getPersona().getApellido1());
		Assert.assertNotNull(arbitroCargado.getPersona().getApellido2());
		Assert.assertNotNull(arbitroCargado.getPersona().getNombre());
		Assert.assertNotNull(arbitroCargado.getPersona().getDni());
	}

	@Override
	protected Arbitro hookModificacionDeObjetoDePruebasParaActualizacion(Arbitro arbitroPruebas) {
		arbitroPruebas.getPersona().setNombre("nombre2");
		return arbitroPruebas;
	}

	@Override
	protected void hookComprobacionObjetoActualizadoEnBD(Arbitro objetoParaActualizar, Arbitro objetoActualizado) {
		Assert.assertEquals(objetoParaActualizar.getPersona().getNombre(),objetoActualizado.getPersona().getNombre());
	}

}
