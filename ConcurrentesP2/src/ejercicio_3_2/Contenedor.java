package ejercicio_3_2;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Contenedor {
	//Numero de piezas que contiene el contenedor inicialmente
	private AtomicInteger numPiezas;
	//ID del contenedor
	private int id;
	//ID (1 o 2) del ultimo brazo que manifesto su interes de ejecutar la SC
	private int ultimoB;
	//Valores booleanos
	private AtomicReferenceArray<AtomicBoolean> en;
	
	/*
	 * Constructor de la clase
	 */
	public Contenedor(int idCont, int tamaño) {
		this.id = idCont;
		this.numPiezas = new AtomicInteger(tamaño);
		this.ultimoB = 1;
		this.en = new AtomicReferenceArray<AtomicBoolean>(5);
		//ponemos a false en[i]
		for(int i=0;i<5;i++) {
			en.set(i, new AtomicBoolean(false));
		}
	}
	
	/*
	 * Decrementa el valor de numPiezas
	 */
	public void vaciar() {
		this.numPiezas.decrementAndGet();
	}
	
	/*
	 * Devuelve id (ID del contenedor)
	 */
	public int getIdCont() {
		return this.id;
	}
	
	/*
	 * Devuelve el valor de ultimoB (ID del ultimo brazo)
	 */
	public int getUltimoB() {
		return  this.ultimoB;
	}
	
	/*
	 * Modifica el valor de ultimoB (ID del ultimo brazo)
	 */
	public void setUltimoB(int idB) {
		this.ultimoB = idB;
	}
	
	/*
	 * Devuelve el valor de en[X]
	 */
	public AtomicBoolean getEn(int idBrazo) {
		return en.get(idBrazo);
	}
	
	/*
	 * Modifica el valor de en[X]
	 */
	public void setEn(int idBrazo, boolean b) {
		en.set(idBrazo, new AtomicBoolean(b));
	}
}
