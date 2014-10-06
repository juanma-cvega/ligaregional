package com.jusoft.ligaregional.servicios.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.servicios.ArbitroService;

@Component
@Path("/arbitros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArbitroResource {

	@Autowired
	private ArbitroService arbitroService; 
	
	@Path(value = "/arbitro/{id}")
	@GET
	public Arbitro getArbitro(@PathParam("id") Long id) {
		return arbitroService.cargar(id);
	}
	
	@Path(value = "/arbitro/")
	@POST
	public Arbitro postArbitro(Arbitro arbitro){
		return arbitroService.guardar(arbitro);
	}
	
	@GET
	public List<Arbitro> getArbitros(){
		return arbitroService.obtenerTodos();
	}
	
	@Path(value = "/arbitro/{id}")
	@PUT
	public void putArbitro(@PathParam("id") Long id, Arbitro arbitro) {
		arbitro.setId(id);
		arbitroService.actualizar(arbitro);
	}
	
	@Path(value = "/arbitro/{id}")
	@DELETE
	public void deleteArbitro(@PathParam("id") Long id){
		arbitroService.borrar(id);
	}

}
