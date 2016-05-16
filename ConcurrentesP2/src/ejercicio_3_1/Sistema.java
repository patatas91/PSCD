package ejercicio_3_1;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class Sistema {
	
	public static void main(String[] args) {
		Thread t1, t2;
		Brazo b1, b2;
		Contenedor cont = new Contenedor(1, 50);
		
		//Creamos los brazos
		b1 = new Brazo(0,25,cont);
		b2 = new Brazo(1,25,cont);
		
		//Creamos los Threads
		t1 = new Thread(b1);
		t2 = new Thread(b2);
		
		//Lanzamos los Threads
		t1.start();
		t2.start();
	}

}
