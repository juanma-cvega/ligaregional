package com.jusoft.ligaregional.persistencia.dao.datosmock;


import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.persistencia.modelo.Direccion;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Persona;

public class ArbitroDatosMock {
	
	private ArbitroDatosMock(){}
	
	public static Arbitro mockArbitro(){
		return mockArbitro(1);
	}
	
	public static Arbitro mockArbitro(int sufijo){
		Arbitro arbitro = new Arbitro();
		Persona persona = new Persona();
		persona.setNombre("nombre" + sufijo);
		persona.setApellido1("apellido1" + sufijo);
		persona.setApellido2("apellido2" + sufijo);
		persona.setDni("12345678" + sufijo);
		arbitro.setPersona(persona);
		arbitro.setNumeroColegiado("numeroColegiado" + sufijo);
		Direccion direccion = new Direccion();
		direccion.setCiudad("ciudad" + sufijo);
		direccion.setCodigoPostal("1234" + sufijo);
		direccion.setCalle("calle" + sufijo);
		direccion.setProvincia("provincia" + sufijo);
		arbitro.setDireccion(direccion);
		return arbitro;
	}
	
	public static List<Modelo<Long>> mockArbitros(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockArbitro(i));
		}
		return listadoMock;
	}

}
