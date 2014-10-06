package com.jusoft.ligaregional.persistencia.dao;

import junit.framework.Assert;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;

public abstract class EquipoDaoTest extends AbstractDaoTest<Equipo> {

	@Override
	protected void hookComprobacionDatosCargadosCorrectamente(Equipo equipoRecuperado) {
		Assert.assertNotNull(equipoRecuperado.getNombre());
		Assert.assertNotNull(equipoRecuperado.getTemporada().getId());
	}
	
	@Override
	protected Equipo hookModificacionDeObjetoParaPruebaDeActualizacion(Equipo equipoPruebas) {
		equipoPruebas.setNombre("nombre2");
		return equipoPruebas;
	}
	
}