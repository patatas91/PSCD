package practica_4_1;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Simulador {

	/**
	 * Crea una tabla de jugadores
	 * 
	 * @param club
	 * @param novatos
	 * @param expertos
	 * @return Jugador[]
	 */
	public static Jugador[] tablaJugadores(Club club, int novatos,
			int expertos, int veces) {
		// Crea la tabla de longitud novatos+expertos
		Jugador[] tabla = new Jugador[novatos + expertos];
		// NOVATOS
		for (int i = 0; i < novatos; i++) {
			tabla[i] = new Jugador(i, "novato", veces, club);
		}
		// EXPERTOS
		for (int j = novatos; j < novatos + expertos; j++) {
			tabla[j] = new Jugador(j, "experto", veces, club);
		}
		return tabla;
	}

	/**
	 * Crea la tabla de Threads
	 * 
	 * @param tablaJugadores
	 * @return Thread[]
	 */
	public static Thread[] hilos(Jugador[] tablaJugadores) {
		Thread[] tablaHilos = new Thread[tablaJugadores.length];
		for (int i = 0; i < tablaJugadores.length; i++) {
			tablaHilos[i] = new Thread(tablaJugadores[i]);
		}
		return tablaHilos;
	}

	/**
	 * Lanza los hilos
	 * 
	 * @param tablaHilos
	 * @throws InterruptedException
	 */
	public static void lanzar(Thread[] tablaHilos) throws InterruptedException {
		for (int i = 0; i != tablaHilos.length; i++) {
			tablaHilos[i].start();
		}
		// Hacemos que no acabe hasta que terminen todos
		for (int i = 0; i != tablaHilos.length; i++) {
			tablaHilos[i].join();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Club con 20 pelotas y 20 palos
		Club club = new Club(20, 20);
		// Crea la tabla de jugadores (7 novatos y 7 expertos) repitiendo su
		// comportamiento 5 veces
		Jugador[] jugadores = tablaJugadores(club, 7, 7, 5);
		// Crea la tabla de hilos
		Thread[] hilos = hilos(jugadores);

		// Inicia la ejecucion - comprobamos material
		System.out.printf("INICIO -> ");
		club.listar();
		lanzar(hilos);
		// Finaliza la ejecucion - comprobamos material
		System.out.printf("FINAL -> ");
		club.listar();
	}

}
