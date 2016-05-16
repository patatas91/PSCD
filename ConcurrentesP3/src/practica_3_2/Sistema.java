package practica_3_2;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Sistema {

	/**
	 * Devuelve una nueva tabla de Escritores.
	 */
	public static Escritor[] escritores(BaseDeDatos BD,
			Semaphore semaforoNombre, Semaphore semaforoApellidos,
			Semaphore semaforoDireccion, int tareas) {
		Escritor[] tablaEscritores = new Escritor[tareas];
		for (int i = 0; i != tareas; i++) {
			tablaEscritores[i] = new Escritor(BD, 110, semaforoNombre,
					semaforoApellidos, semaforoDireccion);
		}
		return tablaEscritores;
	}

	/**
	 * Crea una tabla de Threads
	 */
	public static Thread[] hilos(Escritor[] tablaEscritores) {
		Thread[] tablaThreads = new Thread[tablaEscritores.length];
		for (int i = 0; i != tablaEscritores.length; i++) {
			tablaThreads[i] = new Thread(tablaEscritores[i]);
		}
		return tablaThreads;
	}

	/**
	 * lanza los Threads
	 */
	public static void lanzar(Thread[] tablaThreads) {
		for (int i = 0; i != tablaThreads.length; i++) {
			tablaThreads[i].run();
		}
	}

	public static void main(String[] args) {
		BaseDeDatos BD = new BaseDeDatos();
		Semaphore semaforoNombre = new Semaphore(1);
		Semaphore semaforoApellidos = new Semaphore(1);
		Semaphore semaforoDireccion = new Semaphore(1);
		long tiempoInicio, totalTiempo;
		// Crea la base de datos
		BD.crear();
		// Mostramos la base de datos
		System.out.println("BASE DE DATOS INICIAL: ");
		BD.mostrar();

		// Creamos los escritores
		Escritor[] tablaEscritores = escritores(BD, semaforoNombre,
				semaforoApellidos, semaforoDireccion, 10);
		// Creamos los Threads
		Thread[] tablaThreads = hilos(tablaEscritores);
		// Lanzamos los Threads contando el tiempo
		tiempoInicio = System.currentTimeMillis();
		lanzar(tablaThreads);
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("");
		System.out.println("");
		System.out.println("BASE DE DATOS MODIFICADA: ");
		// Mostramos la base de datos modificada
		BD.mostrar();
		System.out.println("");
		System.out.println("Tiempo transcurrido: " + totalTiempo
				+ " milisegundos");
	}
}
