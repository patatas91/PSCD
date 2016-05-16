package ejer2_1;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

class PruebaFairness {

	/** 
	* Crea un objeto DatosComunes que lo asigna a la variable dC y dos procesos de tipo Sigo y Acabo.
	* Lanza los dos procesos realizando una llamada al método start() de cada uno de ellos.
	* 
	*/

	public static void main(String args[]){
		DatosComunes dC;
		Sigo s;
		Acabo a;
		Thread t1, t2;
		
		dC = new DatosComunes();
		s = new Sigo(dC);
		a = new Acabo(dC);
		
		t1 = new Thread (s);
		t2 = new Thread (a);

		t1.start();
		t2.start();
	}
}

