package ejercicio_2_2;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class ejercicio_2_2 implements Runnable {
	private final int n = 10;
	private int[] C;
	private int[] D;
	private int i;
	private DatosComunes datosComunes;
	
	/*
	 * Constructor de la clase
	 */
	public ejercicio_2_2 (int[] C2, int[] D2, int ind, DatosComunes DC) {
		this.C = C2;
		this.D = D2;
		this.i = ind;
		this.datosComunes = DC;
	}
	
	public void run(){
		int myNumber;
		int count = 0;
		
		myNumber = C[i];
		//Contamos los numeros menores
		for (int d = 0; d<n; d++) {
			if (C[d] < myNumber) {
				count++;
			}
		}
		//Actualizamos el valor en D
		D[count] = myNumber;
		datosComunes.aumentar();
	}
}
