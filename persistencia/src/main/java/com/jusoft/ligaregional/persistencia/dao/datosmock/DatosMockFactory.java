package com.jusoft.ligaregional.persistencia.dao.datosmock;

import java.util.List;

import com.jusoft.ligaregional.persistencia.modelo.Modelo;

public class DatosMockFactory {
	
	private enum TipoModelo{
		ARBITRO,EQUIPO,JUGADOR,PARTIDO,POLIDEPORTIVO,TEMPORADA
	}
	
	public static Modelo<Long> getDatosMock(Class<? extends Modelo<Long>> claseModelo){
		TipoModelo tipoModelo = TipoModelo.valueOf(claseModelo.getSimpleName().toUpperCase());
		switch (tipoModelo) {
		case ARBITRO:
			return ArbitroDatosMock.mockArbitro();
		case EQUIPO:
			return EquipoDatosMock.mockEquipo();
		case JUGADOR:
			return JugadorDatosMock.mockJugador();
		case PARTIDO:
			return PartidoDatosMock.mockPartido();
		case POLIDEPORTIVO:
			return PolideportivoDatosMock.mockPolideportivo();
		case TEMPORADA:
			return TemporadaDatosMock.mockTemporada();
		default:
			return null;
		}
	}
	
	public static List<Modelo<Long>> getListadoDatosMock(Class<? extends Modelo<Long>> claseModelo, int numeroDatosMock){
		TipoModelo tipoModelo = TipoModelo.valueOf(claseModelo.getSimpleName().toUpperCase());
		switch(tipoModelo){
		case ARBITRO:
			return ArbitroDatosMock.mockArbitros(numeroDatosMock);
		case EQUIPO:
			return EquipoDatosMock.mockEquipos(numeroDatosMock);
		case JUGADOR:
			return JugadorDatosMock.mockJugadores(numeroDatosMock);
		case PARTIDO:
			return PartidoDatosMock.mockPartidos(numeroDatosMock);
		case POLIDEPORTIVO:
			return PolideportivoDatosMock.mockPolideportivos(numeroDatosMock);
		case TEMPORADA:
			return TemporadaDatosMock.mockTemporadas(numeroDatosMock);
		default:
			return null;
		}
	}
}
