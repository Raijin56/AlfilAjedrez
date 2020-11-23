/**
 * 
 */
package org.iesalandalus.programacion.alfilajedrez;

/**
 * @author Alberto
 *
 */
public class Alfil {
	
	private Color color;
	private Posicion posicion;
	
	private void setPosicion(Posicion posicion) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar una posición nula.");
		}
		this.posicion = posicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
}
