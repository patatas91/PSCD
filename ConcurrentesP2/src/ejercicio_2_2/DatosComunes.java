package ejercicio_2_2;

public class DatosComunes {
	
	public int[] C;
	public int[] D;
	public int contador = 0;
	
	/*
	 * Constructor de la clase
	 */
	public DatosComunes(int[] tabla, int[] tabla2) {
		this.C = tabla;
		this.D = tabla2;
	}
	
	/*
	 * Devuelve la tabla C
	 */
	public int[] getC() {
		return C;
	}
	
	/*
	 * Define la tabla C
	 */
	public void setC(int[] t) {
		this.C = t;
	}

	/*
	 * Devuelve la tabla D
	 */
	public int[] getD() {
		return D;
	}
	
	/*
	 * Define la tabla D
	 */
	public void setD(int[] t2) {
		this.D = t2;
	}
	
	/*
	 * Aumenta en uno el contador de Threads
	 */
	public void aumentar() {
		contador = contador+1;
	}
	
	/*
	 * Devuelve True si el contador es 10
	 */
	public boolean finalizar() {
		return contador == 10;
	}


}
