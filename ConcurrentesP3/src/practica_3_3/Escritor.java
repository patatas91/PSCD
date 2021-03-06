package practica_3_3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Escritor implements Runnable {

	private BaseDeDatos BD;
	// Tabla de semaforos
	private ConcurrentHashMap<Integer,Semaphore> semaforos;
	private int numOperaciones;

	/**
	 * Constructor de la clase
	 */
	public Escritor(BaseDeDatos BD, ConcurrentHashMap<Integer,Semaphore> semaforos, int numOperaciones) {
		this.BD = BD;
		this.semaforos = semaforos;
		this.numOperaciones = numOperaciones;
	}

	/**
	 * Aumentar ultima cifra del String 'valor'
	 */
	public String aumentar(String valor) {
		int numero = Integer.parseInt(valor.substring(valor.length() - 1));
		numero = numero + 1;
		return valor.substring(0, valor.length() - 1) + numero;
	}

	/**
	 * Metodo run que resuelve el problema de los lectores/escritores
	 */
	public void run() {
		// Datos a modificar
		String nombre;
		String apellido;
		String direccion;
		for (int i = 0; i < numOperaciones; i++) {
			// Generamos al clave aleatoria entre 1001 y 1100
			int clave = (int) Math.floor(Math.random() * (1100 - 1001 + 1)
					+ 1001);
			// WAIT
			try {
				semaforos.get(clave).acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Modificamos los datos obtenidos
			nombre = aumentar(BD.getNombre(clave));
			apellido = aumentar(BD.getApellidos(clave));
			direccion = aumentar(BD.getDireccion(clave));
			// Los actualizamos en la base de datos
			BD.updateNombre(clave, nombre);
			BD.updateApellidos(clave, apellido);
			BD.updateDireccion(clave, direccion);
			// SIGNAL
			semaforos.get(clave).release();
		}
	}

}
