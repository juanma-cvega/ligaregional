package com.jusoft.ligaregional.persistencia.utils;

public class RelanzadorExcepciones {
	public static RuntimeException lanzar(Exception ex) {
		RelanzadorExcepciones.<RuntimeException> lanzarComoUnchecked(ex);

		throw new AssertionError("Esta l�nea  nunca se ejecutar� pero Java no lo sabe");
	}

	@SuppressWarnings("unchecked")
	private static <T extends Exception> void lanzarComoUnchecked(Exception toThrow) throws T {
		throw (T) toThrow;
	}
}