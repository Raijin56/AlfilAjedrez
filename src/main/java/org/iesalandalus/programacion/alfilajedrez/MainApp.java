/**
 * 
 */
package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

/**
 * @author Alberto
 *
 */
public class MainApp {

	private static Alfil alfil;
	private static boolean salir;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un alfil en el tablero de ajedrez");
		System.out.println("--------------------------------------------------------------------------");
		do {
			mostrarMenu();
			ejecutarOpcion(elegirOpcion());
			mostrarAlfil();
		} while (!salir);
		System.out.println("Hasta luego Lucas!!!!");
	}

	private static void mostrarAlfil() {
		if (alfil != null && !salir) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(alfil);
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	private static void mostrarMenu() {
		System.out.println("1. Crear un alfil por defecto");
		System.out.println("2. Crear un alfil de un color");
		System.out.println("3. Crear un alfil de un color en una columna inicial dada");
		System.out.println("4. Mover el alfil");
		System.out.println("5. Salir");
	}

	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.print("Introduce una opción: ");
			opcion = Entrada.entero();
			if (opcion < 1 || opcion > 5) {
				System.out.println("Debe ser una opción comprendida entre 1 y 5.");
			}
		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	private static Color elegirColor() {
		int opcionColor;
		do {
			System.out.print("Introduce 1 si quieres color blanco o 2 si quieres color negro: ");
			opcionColor = Entrada.entero();
			if (opcionColor < 1 || opcionColor > 2) {
				System.out.println("Debe ser uno de esos dos números.");
			}
		} while (opcionColor < 1 || opcionColor > 2);

		Color color;
		switch (opcionColor) {
		case 1:
			color = Color.BLANCO;
			break;
		case 2:
			color = Color.NEGRO;
			break;
		default:
			color = Color.BLANCO;
			System.out.println("Valor inesperado: " + opcionColor);
			System.out.println("Te he puesto color blanco.");
			break;
		}
		return color;
	}

	private static char elegirColumnaInicial() {
		char columnaInicial;
		do {
			System.out.print("Introduce la columna inicial (c o f): ");
			columnaInicial = Character.toLowerCase(Entrada.caracter());
			if (columnaInicial != 'c' && columnaInicial != 'f') {
				System.out.println("ERROR: Columna no válida.");
			}
		} while (columnaInicial != 'c' && columnaInicial != 'f');
		return columnaInicial;
	}

	private static void mostrarMenuDirecciones() {
		System.out.println("1. Arriba derecha");
		System.out.println("2. Abajo derecha");
		System.out.println("3. Abajo izquierda");
		System.out.println("4. Arriba izquierda");
	}

	private static Direccion elegirDireccion() {
		int opcionDireccion;
		do {
			System.out.print("Introduce una opción: ");
			opcionDireccion = Entrada.entero();
			if (opcionDireccion < 1 || opcionDireccion > 4) {
				System.out.println("Debe ser uno de esos cuatro números.");
			}
		} while (opcionDireccion < 1 || opcionDireccion > 4);

		Direccion direccion;
		switch (opcionDireccion) {
		case 1:
			direccion = Direccion.ARRIBA_DERECHA;
			break;
		case 2:
			direccion = Direccion.ABAJO_DERECHA;
			break;
		case 3:
			direccion = Direccion.ABAJO_IZQUIERDA;
			break;
		case 4:
			direccion = Direccion.ARRIBA_IZQUIERDA;
			break;
		default:
			direccion = Direccion.ARRIBA_DERECHA;
			System.out.println("Valor inesperado: " + direccion);
			System.out.println("Te he puesto dirección arriba derecha.");
			break;
		}
		return direccion;
	}

	private static void crearAlfilDefecto() {
		alfil = new Alfil();
	}

	private static void crearAlfilColor() {
		Color color = elegirColor();
		alfil = new Alfil(color);
	}

	private static void crearAlfilColorColumna() {
		Color color = elegirColor();
		char columnaInicial = elegirColumnaInicial();
		alfil = new Alfil(color, columnaInicial);
	}

	private static void mover() {
		if (alfil == null) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Primero tienes que crear un alfil.");
			System.out.println("--------------------------------------------------------------------------");
			return;
		}
		mostrarMenuDirecciones();
		Direccion direccion = elegirDireccion();
		System.out.print("¿Cuántos pasos quieres que dé el alfil?: ");
		int pasos = Entrada.entero();
		try {
			alfil.mover(direccion, pasos);
		} catch (OperationNotSupportedException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			// Crear un alfil por defecto
			crearAlfilDefecto();
			break;
		case 2:
			// Crear un alfil de un color
			crearAlfilColor();
			break;
		case 3:
			// Crear un alfil de un color en una columna inicial dada
			crearAlfilColorColumna();
			break;
		case 4:
			// Mover el alfil
			mover();
			break;
		case 5:
			// Salir
			salir = true;
			break;
		default:
			break;
		}
	}
}
