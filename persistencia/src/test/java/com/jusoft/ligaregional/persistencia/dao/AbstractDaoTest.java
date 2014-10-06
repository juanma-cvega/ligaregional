package com.jusoft.ligaregional.persistencia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jusoft.ligaregional.persistencia.dao.datosmock.DatosMockFactory;
import com.jusoft.ligaregional.persistencia.modelo.AbstractModelo;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractDaoTest<T extends AbstractModelo<Long>> {

	protected AbstractDao<T, Long> abstractDao;
	private T objetoPruebas;
	private Class<T> clasePersistida;

	@SuppressWarnings("unchecked")
	public AbstractDaoTest(){
		this.clasePersistida = (Class<T>)((ParameterizedType) ((Class<T>)(getClass()
				.getGenericSuperclass())).getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Test
	public void testCrudObjeto(){
		testearInsercionDeObjeto();
		testearCargaDeObjeto();
		testearActualizacionDeObjeto();
		testearBorradoDeObjeto();
	}
	
	@Test
	public void testObtenerTodos(){
		int numeroObjetosParaPrueba = 2;
		List<Modelo<Long>> listadoDatosMock = dadoUnListadoDeObjetosParaGuardar(numeroObjetosParaPrueba);
		cuandoSeGuardanElListado(listadoDatosMock);
		entoncesExisteAlMenosElMismoNumeroDeObjetosEnBD(numeroObjetosParaPrueba);
	}

	private List<Modelo<Long>> dadoUnListadoDeObjetosParaGuardar(int numeroObjetosParaPrueba){
		return DatosMockFactory.getListadoDatosMock(clasePersistida, numeroObjetosParaPrueba);
	}
	
	@SuppressWarnings("unchecked")
	private void cuandoSeGuardanElListado(List<Modelo<Long>> listadoDatosMock) {
		for (Modelo<Long> datoModelo : listadoDatosMock) {
			T datoParaGuardar = (T) datoModelo;
			abstractDao.guardar(datoParaGuardar);
		}
	}
	
	private void entoncesExisteAlMenosElMismoNumeroDeObjetosEnBD(int numeroObjetosParaPrueba) {
		List<T> listadoDatosGuardados = abstractDao.obtenerTodos();
		Assert.assertTrue(listadoDatosGuardados.size() >= numeroObjetosParaPrueba);
	}
	
	private void testearInsercionDeObjeto(){
		T objetoParaGuardar = dadoUnObjetoSinId();
		objetoPruebas = cuandoGuardoUnObjetoEnBD(objetoParaGuardar);
		entoncesTengoUnObjetoConId(objetoPruebas);
	}
	
	@SuppressWarnings("unchecked")
	private T dadoUnObjetoSinId() {
		return (T) DatosMockFactory.getDatosMock(clasePersistida);
	}
	
	private T cuandoGuardoUnObjetoEnBD(T objetoParaGuardar) {
		objetoParaGuardar = abstractDao.guardar(objetoParaGuardar);
		return objetoParaGuardar;
	}
	
	private void entoncesTengoUnObjetoConId(T objetoGuardado) {
		Assert.assertNotNull(objetoGuardado);
		Assert.assertNotNull(objetoGuardado.getId());
	}
	
	private void testearCargaDeObjeto(){
		Long identificadorObjeto = dadoUnIdentificadorDeObjeto();
		T objetoCargado = cuandoCargoElObjetoAsociado(identificadorObjeto);
		entoncesTengoLosDatosDelObjeto(objetoCargado);
	}

	private Long dadoUnIdentificadorDeObjeto() {
		return objetoPruebas.getId();
	}

	private T cuandoCargoElObjetoAsociado(Long identificador) {
		T objetoRecuperado = abstractDao.cargar(identificador);
		return objetoRecuperado;
	}
	
	private void entoncesTengoLosDatosDelObjeto(T objetoRecuperado){
		hookComprobacionDatosCargadosCorrectamente(objetoRecuperado);
	}
	
	abstract protected void hookComprobacionDatosCargadosCorrectamente(T objetoRecuperado);
	
	private void testearActualizacionDeObjeto(){
		T objetoParaActualizar = dadoUnObjetoParaActualizar();
		cuandoActualizoSusDatos(objetoParaActualizar);
		entoncesLosDatosDelObjetoEstanActualizados(objetoParaActualizar);
	}

	private T dadoUnObjetoParaActualizar() {
		return hookModificacionDeObjetoParaPruebaDeActualizacion(objetoPruebas);
	}

	abstract protected T hookModificacionDeObjetoParaPruebaDeActualizacion(T objetoPruebas);
	
	private void cuandoActualizoSusDatos(T objetoParaActualizar) {
		abstractDao.actualizar(objetoParaActualizar);
	}
	
	private void entoncesLosDatosDelObjetoEstanActualizados(T objetoParaActualizar) {
		T objetoActualizado = abstractDao.cargar(objetoParaActualizar.getId());
		Assert.assertEquals(objetoParaActualizar, objetoActualizado);
	}
	
	private void testearBorradoDeObjeto() {
		Long identificadorObjeto = dadoUnObjetoConIdentificador();
		cuandoBorroElObjeto(identificadorObjeto);
		entoncesElObjetoNoSeEncuentraEnBD(identificadorObjeto);
	}
	
	private Long dadoUnObjetoConIdentificador() {
		return objetoPruebas.getId();
	}

	private void cuandoBorroElObjeto(Long identificadorObjeto) {
		abstractDao.borrar(identificadorObjeto);
	}
	
	private void entoncesElObjetoNoSeEncuentraEnBD(Long identificadorObjeto) {
		T objetoBorrado = abstractDao.cargar(identificadorObjeto);
		Assert.assertNull(objetoBorrado);
	}

	protected void setAbstractDao(AbstractDao<T, Long> abstractDao) {
		this.abstractDao = abstractDao;
	}
}
