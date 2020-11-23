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
	
	public Alfil() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'f');
	}

	public Alfil(Color color) {
		setColor(color);
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'f');
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'f');
		}
	}

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
