package practica_4_1;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Jugador implements Runnable {

	// ID del jugador
	private int id;
	// Nº pelotas
	private int pelotas;
	// Nº palos
	private int palos;
	// Tipo de jugador
	private String tipo;
	// Club del jugador
	private Club club;
	// Numero de iteraciones
	private int veces;

	/*
	 * Constructor de la clase
	 */
	public Jugador(int id, String tipo, int veces, Club club) {
		this.id = id;
		this.tipo = tipo;
		this.club = club;
		this.veces = veces;
		// Segun el tipo de usuario le asignamos el material
		this.asignar();
	}

	/**
	 * Asigna al usuario unas pelotas y palos dependiendo del tipo de usuario
	 * que sea, novato o experto
	 */
	public void asignar() {
		// NOVATOS
		if (this.tipo == "novato") {
			// 1-5 pelotas
			this.pelotas = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
			;
			// 2 palos
			this.palos = 2;
		} else {
			// EXPERTOS
			// 1 pelota
			this.pelotas = 1;
			// 2-5 palos
			this.palos = (int) Math.floor(Math.random() * (5 - 2 + 1) + 2);
		}
	}

	/**
	 * Cada jugador debera reservar un material al club, una vez haya conseguido
	 * reservar el material podra comenzar a jugar. Una vez acabada la actividad
	 * del usuario, este devolvera el material alquilado y descansara.
	 * 
	 * RESERVAR - JUGAR - DEVOLVER - DESCANSAR
	 */
	public void run() {
		for (int i = 0; i < veces; i++) {
			// Reservar
			System.out
					.println(id + " - Reserva[" + pelotas + "," + palos + "]");
			try {
				club.alquilar(pelotas, palos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Jugar
			System.out.println(id + " - Juega[" + pelotas + "," + palos + "]");
			try {
				Thread.sleep((int) Math.floor(Math.random() * (1000 + 1) + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Devolver
			System.out.println(id + " - Devuelve[" + pelotas + "," + palos
					+ "]");
			club.devolver(pelotas, palos);

			// Descansar
			System.out.println(id + " - Descansa[" + pelotas + "," + palos
					+ "]");
			try {
				Thread.sleep((int) Math.floor(Math.random() * (1000 + 1) + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Volvemos a asignarle el material
			this.asignar();
		}
	}

}
