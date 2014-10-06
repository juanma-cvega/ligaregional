package com.jusoft.ligaregional.persistencia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	public static final String DEFAULT_DATE = "yyyy/MM/dd";
	public static final String DEFAULT_DATETIME = "yyyy/MM/dd hh:mm:ss";

	private DateUtils(){}
	
	public static Date parseoDateConFormato(String formato, String fecha){
		SimpleDateFormat formateador = new SimpleDateFormat(formato);
		try {
			return formateador.parse(fecha);
		} catch (ParseException e) {
			RelanzadorExcepciones.lanzar(e);
			return null;
		}
	}
	
	/**
	 * Usa como formateo por defecto yyyy/MM/dd
	 * @param fecha
	 * @return
	 */
	public static Date parseoDateConFormato(String fecha){
		return parseoDateConFormato(DEFAULT_DATE, fecha);
	}
}
