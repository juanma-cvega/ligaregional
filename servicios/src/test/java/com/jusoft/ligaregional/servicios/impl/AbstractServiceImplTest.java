package com.jusoft.ligaregional.servicios.impl;

import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;
import com.jusoft.ligaregional.servicios.AbstractService;
import com.jusoft.ligaregional.servicios.constantes.RutasDeContextos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = RutasDeContextos.SERVICIOS)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public abstract class AbstractServiceImplTest<T extends AbstractModelo<ID>, ID extends Serializable> {

	protected AbstractService<T,ID> service;
	private T objetoPruebas;
	
	@Test
	public void testGuardar(){
		testeoGuardarObjeto();
		testeoCargarObjeto();
		testeoActualizarObjeto();
		testeoBorrarObjeto();
	}
	
	private void testeoGuardarObjeto() {
		T objetoParaGuardar = dadoUnObjetoParaGuardar();
		objetoPruebas = cuandoGuardoElObjeto(objetoParaGuardar);
		entoncesTengoUnObjetoConIdentificador(objetoParaGuardar);
	}

	private void testeoCargarObjeto() {
		ID identificador = dadoUnIdentificadorDeObjeto();
		T objetoCargado = cuandoCargoSuObjetoAsociado(identificador);
		entoncesTengoUnObjetoCargado(objetoCargado);
	}

	private void testeoActualizarObjeto() {
		T objetoPruebas = dadoUnObjetoParaActualizar();
		cuandoActualizoElObjeto(objetoPruebas);
		entoncesTengoElObjetoActualizadoEnBD(objetoPruebas);
	}

	private void testeoBorrarObjeto() {
		ID identificadorObjeto = dadoUnIdentificadorDeObjetoParaBorrar();
		cuandoBorroElObjeto(identificadorObjeto);
		entoncesElObjetoNoSeEncuentraEnBD(identificadorObjeto);
	}

	private T dadoUnObjetoParaGuardar() {
		return hookObjetoParaGuardar();
	}
	
	protected abstract T hookObjetoParaGuardar();

	private T cuandoGuardoElObjeto(T objetoParaGuardar) {
		return service.guardar(objetoParaGuardar);
	}

	private void entoncesTengoUnObjetoConIdentificador(T objetoParaGuardar2) {
		Assert.assertNotNull(objetoPruebas);
		Assert.assertNotNull(objetoPruebas.getId());
	}
	
	private ID dadoUnIdentificadorDeObjeto() {
		return objetoPruebas.getId();
	}

	private T cuandoCargoSuObjetoAsociado(ID identificador) {
		return service.cargar(identificador);
	}

	private void entoncesTengoUnObjetoCargado(T objetoCargado) {
		hookComprobacionObjetoCargadoConDatos(objetoCargado);
	}

	protected abstract void hookComprobacionObjetoCargadoConDatos(T objetoCargado);

	private T dadoUnObjetoParaActualizar() {
		return hookModificacionDeObjetoDePruebasParaActualizacion(objetoPruebas);
	}

	protected abstract T hookModificacionDeObjetoDePruebasParaActualizacion(T objetoPruebas);
	
	private void cuandoActualizoElObjeto(T objetoPruebas) {
		service.actualizar(objetoPruebas);
	}
	
	private void entoncesTengoElObjetoActualizadoEnBD(T objetoPruebas) {
		T objetoCargado = service.cargar(objetoPruebas.getId());
		hookComprobacionObjetoActualizadoEnBD(objetoPruebas,objetoCargado);
	}
	
	protected abstract void hookComprobacionObjetoActualizadoEnBD(T objetoParaActualizar,T objetoActualizado);

	private ID dadoUnIdentificadorDeObjetoParaBorrar() {
		return objetoPruebas.getId();
	}

	private void cuandoBorroElObjeto(ID identificadorObjeto) {
		service.borrar(identificadorObjeto);
	}

	private void entoncesElObjetoNoSeEncuentraEnBD(ID identificadorObjeto) {
		T objetoBorrado = service.cargar(identificadorObjeto);
		Assert.assertNull(objetoBorrado);
	}

	public void setService(AbstractService<T,ID> service) {
		this.service = service;
	}

}
