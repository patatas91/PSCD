package ejercicio_2_1;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class ejercicio_2_1Main {
	
	public static void main (String[] args) throws InterruptedException {
		Thread[] hilos = new Thread[10];
		ejercicio_2_1[] ejer = new ejercicio_2_1[10];		
		int[] D = new int[10];
		int[] C = {2,6,5,9,1,7,8,3,4,0};		
		
		//Tabla sin ordenar
		for(int f=0;f<C.length;f++){
			System.out.print(" "+C[f]+" ");
		}
		for(int x=0;x<ejer.length;x++) {
			ejer[x] = new ejercicio_2_1(C, D, x);
		}
		//Creamos los Threads
		for(int w=0;w<hilos.length;w++) {
			hilos[w] = new Thread(ejer[w]);
		}
		//Lanzo los Threads
		for(int p=0;p<hilos.length;p++) {
			hilos[p].start();
		}			
		System.out.println("");
		
		//Esperamos a que la tabla se ordene
		Thread.sleep(100);
		//Tabla ordenada
		for(int z=0;z<D.length;z++){
			System.out.print(" "+D[z]+" ");
		}
	}
	
}
