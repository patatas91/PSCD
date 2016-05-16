package ejer2_1;


/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

class Sigo implements Runnable{

	/**
	* El atributo datosComunes almacena la referencia a un objeto de tipo DatosComunes. 
	* 
	*/	

	private DatosComunes datosComunes;

	/** 
	* Define el constructor de objetos Sigo especificándole el valor del atributo datosComunes.
	* 
	* @param DatosComunes d indica el valor que se desea asignar al atributo datosComunes
	* 
	*/

	public Sigo(DatosComunes d){
		this.datosComunes = d;
	}

	/** 
	* Devuelve void. 
	* Realiza iterativamente una llamada al método getSeguir del atributo datosComunes.
	* Si el valor devuelto por dicho método es true entonces imprime un mensaje por pantalla
	* indicanto cuantas veces ha realizado esta acción y vuelve a llamar al método getSeguir.   
	* Si el valor devuelto por dicho método es false entonces imprime un mensaje por pantalla 
	* indicando cuantas llamadas ha realizado al método getSeguir y finaliza la ejecución.
	* 
	*/

	public void run(){
		int i = 0;
		while(datosComunes.getSeguir()){
			i = i + 1;
			System.out.println("Sigo: "+i);
		}
		if (i==0) {
			System.out.println("Sigo: "+i);
		}
	}
}

