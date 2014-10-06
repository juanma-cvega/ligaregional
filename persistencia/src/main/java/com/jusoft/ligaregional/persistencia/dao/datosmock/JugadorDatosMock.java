package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.ArrayList;
import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;
import com.jusoft.ligaregional.persistencia.modelo.Jugador;
import com.jusoft.ligaregional.persistencia.modelo.Modelo;
import com.jusoft.ligaregional.persistencia.modelo.Persona;
import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public class JugadorDatosMock {

	private JugadorDatosMock(){}
	
	public static Jugador mockJugador(){
		return mockJugador(1);
	}
	
	public static Jugador mockJugador(int sufijo) {
		Jugador jugador = new Jugador();
		Persona persona = new Persona();
		persona.setNombre("nombre" + sufijo);
		persona.setApellido1("apellido1" + sufijo);
		persona.setApellido2("apellido2" + sufijo);
		persona.setDni("dni" + sufijo);
		jugador.setPersona(persona);
		jugador.setCapitan(false);
		Equipo mockEquipo = new Equipo();
		mockEquipo.setId(1L);
		jugador.setEquipo(mockEquipo);
		Temporada mockTemporada = new Temporada();
		mockTemporada.setId(1L);
		jugador.setTemporada(mockTemporada);
		return jugador;
	}

	public static List<Modelo<Long>> mockJugadores(int numeroDatosMock){
		List<Modelo<Long>> listadoMock = new ArrayList<>();
		for (int i = 0;i <= numeroDatosMock;i++){
			listadoMock.add(mockJugador(i));
		}
		return listadoMock;
	}
	
}
