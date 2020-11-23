/**
 * 
 */
package org.iesalandalus.programacion.alfilajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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

	public Alfil(Color color, char columnaInicial) {
		if (columnaInicial != 'c' && columnaInicial != 'f') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		setColor(color);
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columnaInicial);
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, columnaInicial);
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

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos <= 0) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}
		switch (direccion) {
		case ARRIBA_DERECHA:
			try {
				setPosicion(new Posicion(posicion.getFila() + pasos, (char) (posicion.getColumna() + pasos)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ABAJO_DERECHA:
			try {
				setPosicion(new Posicion(posicion.getFila() - pasos, (char) (posicion.getColumna() + pasos)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ABAJO_IZQUIERDA:
			try {
				setPosicion(new Posicion(posicion.getFila() - pasos, (char) (posicion.getColumna() - pasos)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ARRIBA_IZQUIERDA:
			try {
				setPosicion(new Posicion(posicion.getFila() + pasos, (char) (posicion.getColumna() - pasos)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		default:
			break;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alfil)) {
			return false;
		}
		Alfil other = (Alfil) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

}
