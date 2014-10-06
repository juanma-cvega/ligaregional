package com.jusoft.ligaregional.servicios.jersey.resources;

import java.util.List;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArbitroResourceClientTest {

	@Test
	public void testCrud(){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client cliente = Client.create(clientConfig);
//		WebResource recurso = cliente.resource("http://localhost:8080/serviciosjersey/rest/arbitros/arbitro/");
//		recurso.accept(MediaType.APPLICATION_JSON);
//		recurso.type(MediaType.APPLICATION_JSON);
//		Arbitro arbitro = ArbitroDatosMock.mockArbitro();
//		arbitro = recurso.post(Arbitro.class,arbitro);
//		Assert.assertNotNull(arbitro);
		WebResource recurso = cliente.resource("http://localhost:8080/serviciosjersey/rest/arbitros/");
		recurso.accept(MediaType.APPLICATION_JSON);
		recurso.type(MediaType.APPLICATION_JSON);
		List<Arbitro> lista = recurso.get(List.class);
		Assert.assertNotNull(lista);
	}
}
