/*
 * Programación de Sistemas Concurrentes y Distribuidos
 * Curso 2013-2014. Grado de Informática
 *
 * @author PSCD
 *
 * Descripción: La clase BaseDeDatos implementa una base de
 * Datos basada en estruturas Hash para almacenar información
 * de personas conforme la estructura definida en el
 * enunciado de la práctica 3.
 */

package practica_3_2;

import java.util.Hashtable;

/**
 * 
 * @author Cristian Simon Moreno, NIP: 611487
 * 
 */
class BaseDeDatos {
	private Hashtable tablaDni;
	private Hashtable tablaNombre;
	private Hashtable tablaDireccion;
	private Hashtable tablaApellidos;

	// Constructor
	public BaseDeDatos() {
		this.tablaNombre = new Hashtable();
		this.tablaApellidos = new Hashtable();
		this.tablaDni = new Hashtable();
		this.tablaDireccion = new Hashtable();
	}

	// Constructor
	public BaseDeDatos(Hashtable nombres, Hashtable apellidos, Hashtable dnis,
			Hashtable direcciones) {
		this.tablaNombre = nombres;
		this.tablaApellidos = apellidos;
		this.tablaDni = dnis;
		this.tablaDireccion = direcciones;
	}

	public Hashtable getTablaNombre() {
		return this.tablaNombre;
	}

	public Hashtable getTablaApellidos() {
		return this.tablaApellidos;
	}

	public Hashtable getTablaDni() {
		return this.tablaDni;
	}

	public Hashtable getTablaDirecciones() {
		return this.tablaDireccion;
	}

	public String getNombre(int clave) {
		return (String) this.tablaNombre.get(clave);
	}

	public String getApellidos(int clave) {
		return (String) this.tablaApellidos.get(clave);
	}

	public String getDni(int clave) {
		return (String) this.tablaDni.get(clave);
	}

	public String getDireccion(int clave) {
		return (String) this.tablaDireccion.get(clave);
	}

	public void updateNombre(int clave, String nombre) {
		this.tablaNombre.remove(clave);
		this.tablaNombre.put(clave, nombre);
	}

	public void updateApellidos(int clave, String apellidos) {
		this.tablaApellidos.remove(clave);
		this.tablaApellidos.put(clave, apellidos);
	}

	public void updateDireccion(int clave, String direccion) {
		this.tablaDireccion.remove(clave);
		this.tablaDireccion.put(clave, direccion);
	}

	public void insertarRegistro(int clave, String nombre, String apellidos,
			String dni, String direccion) {
		this.tablaNombre.put(clave, nombre);
		this.tablaApellidos.put(clave, apellidos);
		this.tablaDni.put(clave, dni);
		this.tablaDireccion.put(clave, direccion);
	}

	/**
	 * Crea una base de datos con 100 registros
	 */
	public void crear() {
		for (int i = 1001; i < 1101; i++) {
			insertarRegistro(i, "Nombre_" + i + "_0", "Apellidos_" + i + "_0",
					"100" + i, "C/ María de Luna " + i + "_0");
		}
	}

	/**
	 * Muestra la base de datos
	 */
	public void mostrar() {
		System.out.println();
		System.out
				.println("clave  DNI      Nombre           Apellidos           Direccion");
		System.out
				.println("---------------------------------------------------------------"
						+ "--------------");
		for (int i = 1001; i < 1101; i++) {
			System.out.printf("%d   %s  %-15s  %-18s  %-25s\n", i, getDni(i),
					getNombre(i), getApellidos(i), getDireccion(i));
		}

	}
}
