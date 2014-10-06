package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;
import com.jusoft.ligaregional.persistencia.utils.DateUtils;

public class TemporadaDatosMock  {

	private TemporadaDatosMock(){}
	
	public static Temporada mockTemporada(){
		return mockTemporada(1);
	}
	
	public static Temporada mockTemporada(int sufijo) {
		Temporada temporada = new Temporada();
		temporada.setFechaFin(DateUtils.parseoDateConFormato("1988/06/" + sufijo));
		temporada.setFechaInicio(DateUtils.parseoDateConFormato("1988/06/" + sufijo));
		return temporada;
	}

	public static List<Modelo<Long>> mockTemporadas(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockTemporada(i));
		}
		return listadoMock;
	}
}
