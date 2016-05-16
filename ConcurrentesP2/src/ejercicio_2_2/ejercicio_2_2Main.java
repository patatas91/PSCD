package ejercicio_2_2;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class ejercicio_2_2Main {	
	
	public static void main (String[] args) {
		
		int[] C = new int[10];
		int[] D = new int[10];
		Thread[] hilos = new Thread[10];
		ejercicio_2_2[] ejer = new ejercicio_2_2[10];
		
		DatosComunes DC = new DatosComunes (C,D);
		proceso1 p1 = new proceso1(DC);		
		
		Thread proc1;	
		proc1 = new Thread(p1);	
		proc1.start();			
		
		for(int x=0;x<ejer.length;x++) {
			ejer[x] = new ejercicio_2_2(DC.getC(), DC.getD(), x, DC);
		}
		//Creamos los Threads
		for(int w=0;w<hilos.length;w++) {
			hilos[w] = new Thread(ejer[w]);
		}
		//Lanzo los Threads
		for(int p=0;p<hilos.length;p++) {
			hilos[p].start();
		}		
	}
	
}
