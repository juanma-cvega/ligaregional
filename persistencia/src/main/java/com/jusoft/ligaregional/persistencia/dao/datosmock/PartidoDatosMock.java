package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;
import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Partido;
import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;
import com.jusoft.ligaregional.persistencia.utils.DateUtils;

public class PartidoDatosMock {

	private PartidoDatosMock(){}
	
	public static Partido mockPartido(){
		return mockPartido(1);
	}
	
	public static Partido mockPartido(int sufijo) {
		Partido partido = new Partido();
		Arbitro arbitro = new Arbitro();
		arbitro.setId(1L);
		partido.setArbitro(arbitro);
		Date fecha = DateUtils.parseoDateConFormato(DateUtils.DEFAULT_DATETIME, "1988/06/06 11:11:11");
		partido.setFecha(fecha);
		Equipo local = new Equipo();
		local.setId(1L + sufijo);
		partido.setLocal(local );
		Polideportivo polideportivo = new Polideportivo();
		polideportivo.setId(1L);
		partido.setPolideportivo(polideportivo);
		Temporada temporada = new Temporada();
		temporada.setId(1L);
		partido.setTemporada(temporada);
		Equipo visitante = new Equipo();
		visitante.setId(2L);
		partido.setVisitante(visitante);
		return partido;
	}
	
	public static List<Modelo<Long>> mockPartidos(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockPartido(i));
		}
		return listadoMock;
	}

}
