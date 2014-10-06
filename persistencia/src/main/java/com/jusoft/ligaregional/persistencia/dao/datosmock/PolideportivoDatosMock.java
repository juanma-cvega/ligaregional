package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Direccion;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

public class PolideportivoDatosMock {

	private PolideportivoDatosMock(){}
	
	public static Polideportivo mockPolideportivo(){
		return mockPolideportivo(1);
	}
	
	public static Polideportivo mockPolideportivo(int sufijo) {
		Polideportivo polideportivo = new Polideportivo();
		polideportivo.setCamposDisponibles(5);
		polideportivo.setNombre("nombre" + sufijo);
		Direccion direccion = new Direccion();
		direccion.setCiudad("ciudad" + sufijo);
		direccion.setCodigoPostal("1234" + sufijo);
		direccion.setCalle("calle" + sufijo);
		direccion.setProvincia("provincia" + sufijo);
		polideportivo.setDireccion(direccion);
		return polideportivo;
	}

	public static List<Modelo<Long>> mockPolideportivos(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockPolideportivo(i));
		}
		return listadoMock;
	}
}
