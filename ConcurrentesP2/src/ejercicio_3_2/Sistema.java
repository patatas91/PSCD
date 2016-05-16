package ejercicio_3_2;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class Sistema {
	
	public static void main(String[] args) {
		Thread[] hilos = new Thread[5];
		Brazo[] brazos = new Brazo[5];		
		Contenedor cont = new Contenedor(1, 50);
		
		//Creamos los brazos
		for(int x=0;x<brazos.length;x++) {
			brazos[x] = new Brazo(x, 10, cont);
		}
		
		//Creamos los Threads
		for(int w=0;w<hilos.length;w++) {
			hilos[w] = new Thread(brazos[w]);
		}
		
		//Lanzamos los Threads
		for(int p=0;p<hilos.length;p++) {
			hilos[p].start();
		}		
	}

}
