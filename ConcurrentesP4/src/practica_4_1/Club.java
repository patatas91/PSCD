package practica_4_1;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Club {

	// Pelotas libres
	private int pelotasLibres;
	// Palos libres
	private int palosLibres;

	/*
	 * Constructor de la clase
	 */
	public Club(int pelotas, int palos) {
		this.pelotasLibres = pelotas;
		this.palosLibres = palos;
	}

	/**
	 * Implementacion de un monitor para el alquiler de material por parte de
	 * los usuarios
	 * 
	 * @param pelotas
	 * @param palos
	 * @throws InterruptedException
	 */
	synchronized void alquilar(int pelotas, int palos)
			throws InterruptedException {
		// Mientras no este disponible el material espera
		while (pelotasLibres < pelotas || palosLibres < palos) {
			wait();
		}
		pelotasLibres = pelotasLibres - pelotas;
		palosLibres = palosLibres - palos;
		notifyAll();
	}

	/**
	 * Metodo para la devolucion de material por parte de los usuarios
	 * 
	 * @param pelotas
	 * @param palos
	 */
	synchronized void devolver(int pelotas, int palos) {
		pelotasLibres = pelotasLibres + pelotas;
		palosLibres = palosLibres + palos;
		notifyAll();
	}

	/**
	 * Lista el material disponible del club
	 */
	public void listar() {
		System.out.println(pelotasLibres + " pelotas - " + palosLibres
				+ " palos");
	}

}
