package com.jusoft.ligaregional.servicios.jersey.resources;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jusoft.ligaregional.persistencia.dao.datosmock.ArbitroDatosMock;
import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext-test.xml")
public class ArbitroResourceTest {

	@Autowired
	private ArbitroResource arbitroResource;

	@Test
	public void testCrud(){
		testeoPost();
		testeoGet();
	}
	
	private void testeoPost() {
		Arbitro arbitro = dadoUnArbitro();
		Arbitro arbitroGuardado = cuandoGuardoElArbitro(arbitro);
		entoncesTengoUnArbitroGuardado(arbitroGuardado);	
	}

	private void testeoGet() {
		Long id = dadoUnIdDeRecurso();
		Arbitro arbitroRecuperado = cuandoRecuperoRecursoAsociado(id);
		entoncesTengoUnArbitroCargado(arbitroRecuperado);
	}

	private Arbitro dadoUnArbitro() {
		return ArbitroDatosMock.mockArbitro();
	}

	private Arbitro cuandoGuardoElArbitro(Arbitro arbitro) {
		return arbitroResource.postArbitro(arbitro);
	}

	private void entoncesTengoUnArbitroGuardado(Arbitro arbitroParaGuardar) {
		Arbitro arbitroGuardado = arbitroResource.getArbitro(arbitroParaGuardar.getId());
		Assert.assertEquals(arbitroParaGuardar, arbitroGuardado);
	}

	private Long dadoUnIdDeRecurso() {
		return 1L;
	}

	private Arbitro cuandoRecuperoRecursoAsociado(Long id) {
		return arbitroResource.getArbitro(id);
	}

	private void entoncesTengoUnArbitroCargado(Arbitro arbitroRecuperado) {
		Assert.assertNotNull(arbitroRecuperado);
		
	}
	
}
