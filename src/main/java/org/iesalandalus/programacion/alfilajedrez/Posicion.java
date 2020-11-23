/**
 * 
 */
package org.iesalandalus.programacion.alfilajedrez;

/**
 * @author Alberto
 *
 */
public class Posicion {

	private int fila;
	private char columna;

	private static final int MIN_FILA = 1;
	private static final int MAX_FILA = 8;
	private static final char MIN_COLUMNA = 'a';
	private static final char MAX_COLUMNA = 'h';

	private void setFila(int fila) {
		if (fila < MIN_FILA || fila > MAX_FILA) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
			this.fila = fila;
		}
	}

	public int getFila() {
		return fila;
	}

	private void setColumna(char columna) {
		if (columna < MIN_COLUMNA || columna > MAX_COLUMNA) {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} else {
			this.columna = columna;
		}
	}

	public char getColumna() {
		return columna;
	}

}
