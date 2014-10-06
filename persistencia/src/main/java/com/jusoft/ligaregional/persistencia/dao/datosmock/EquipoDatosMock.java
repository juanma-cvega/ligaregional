package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class EquipoDatosMock {

	private EquipoDatosMock(){}
	
	public static Equipo mockEquipo(){
		return mockEquipo(1);
	}
	
	public static Equipo mockEquipo(int sufijo) {
		Equipo equipo = new Equipo();
		equipo.setNombre("nombre" + sufijo);
		Temporada temporada = new Temporada();
		temporada.setId(1L);
		equipo.setTemporada(temporada);
		return equipo;
	}

	public static List<Modelo<Long>> mockEquipos(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockEquipo(i));
		}
		return listadoMock;
	}
}
