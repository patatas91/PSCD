package practica_3_2;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
public class Escritor implements Runnable {

	private BaseDeDatos BD;
	private Semaphore semaforoNombre;
	private Semaphore semaforoApellidos;
	private Semaphore semaforoDireccion;
	private int numOperaciones;

	/**
	 * Constructor de la clase
	 */
	public Escritor(BaseDeDatos BD, int numOperaciones,
			Semaphore semaforoNombre, Semaphore semaforoApellidos,
			Semaphore semaforoDireccion) {
		this.BD = BD;
		this.numOperaciones = numOperaciones;
		this.semaforoNombre = semaforoNombre;
		this.semaforoApellidos = semaforoApellidos;
		this.semaforoDireccion = semaforoDireccion;
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
	 * Modifica el nombre y lo actualiza en la base de datos
	 * 
	 * @throws InterruptedException
	 */
	public void modificarNombre(int clave) throws InterruptedException {
		String nombre = aumentar(BD.getNombre(clave));
		// WAIT
		semaforoNombre.acquire();
		BD.updateNombre(clave, nombre);
		// SIGNAL
		semaforoNombre.release();
	}

	/**
	 * Modifica el apellido y lo actualiza en la base de datos
	 * 
	 * @throws InterruptedException
	 */
	public void modificarApellido(int clave) throws InterruptedException {
		String apellido = aumentar(BD.getApellidos(clave));
		// WAIT
		semaforoApellidos.acquire();
		BD.updateApellidos(clave, apellido);
		// SIGNAL
		semaforoApellidos.release();
	}

	/**
	 * Modifica la direccion y lo actualiza en la base de datos
	 * 
	 * @throws InterruptedException
	 */
	public void modificarDireccion(int clave) throws InterruptedException {
		String direccion = aumentar(BD.getDireccion(clave));
		// WAIT
		semaforoDireccion.acquire();
		BD.updateDireccion(clave, direccion);
		// SIGNAL
		semaforoDireccion.release();
	}

	/**
	 * Metodo run que resuelve el problema de los lectores/escritores
	 */
	public void run() {
		for (int i = 0; i < numOperaciones; i++) {
			// Generamos al clave aleatoria entre 1001 y 1100
			int clave = (int) Math.floor(Math.random() * (1100 - 1001 + 1)
					+ 1001);
			try {
				modificarNombre(clave);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				modificarApellido(clave);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				modificarDireccion(clave);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
