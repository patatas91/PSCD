package ejer2_1;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

class DatosComunes{

	/**
	* La variable seguir almacena un valor booleano (true o false). 
	* Se inicializa a true cuando se crea un objeto de esta clase. 
	*/	
	private boolean seguir = true;

	/** 
	* Devuelve void  
	*  
	* @param boolean valor indica el valor que se desea asignar al dato en común
	*
	*/

	public void setSeguir(boolean valor){
		this.seguir = valor;
	}

	/** 
	* Devuelve el valor del dato en común (true o false). 
	* El valor por defecto es true pero algún proceso ha podido cambiarlo.  
	* 
	* @return boolean indica el valor del dato común. 
	*/

	public boolean getSeguir(){
		return seguir;
	}
}
