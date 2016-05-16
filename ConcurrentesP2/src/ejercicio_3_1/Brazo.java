package ejercicio_3_1;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

import java.util.concurrent.atomic.AtomicInteger;

public class Brazo implements Runnable{
	
	//ID unico del brazo
	private int idBrazo;
	//Numero de piezas que deben ser cogidas por el brazo
	private AtomicInteger numCoger;
	//Numero de piezas ya cogidas por el brazo
	private AtomicInteger numCogidas;
	//Contenedor sobre el que se debe trabajar
	private Contenedor contenedor;

	/*
	 * Constructor de la clase
	 */
	public Brazo(int brazo, int coger, Contenedor cont) {
		this.idBrazo = brazo;
		this.numCoger = new AtomicInteger(coger);
		this.numCogidas = new AtomicInteger(0);
		this.contenedor = cont;
	}	
	
	public void run() {
		//mientras falten piezas por recoger
		while(numCoger.intValue()!=numCogidas.intValue()){
			//enX = true
			contenedor.setEn(idBrazo, true);
			//ult = X
			contenedor.setUltimoB(idBrazo);
			//mientras en(otro brazo en SC) y ult no sea este
			while(contenedor.getEn((idBrazo+1)%2) && contenedor.getUltimoB()==idBrazo) {
				//seguir
			}
			//SC
			numCogidas.incrementAndGet();
			contenedor.vaciar();
			//enX = false
			contenedor.setEn(idBrazo, false);
			//SNC
			System.out.println("Brazo "+idBrazo+" descarga una pieza "+numCogidas+" de "+numCoger+
					" del contenedor");
		}		
	}
	

}
