package ejercicio_2_2;

/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

public class proceso1 implements Runnable{
		
	private DatosComunes datosComunes;
	private int[] C = {2,6,5,9,1,7,8,3,4,0};	
	private int[] D = new int[10];
	
	/*
	 * Constructor de la clase
	 */
	public proceso1(DatosComunes DC) {				
		datosComunes = DC;
		datosComunes.setC(C);
		datosComunes.setD(D);
	}
	
	public void run() {	
		//Tabla sin ordenar		
		for(int f=0;f<datosComunes.getC().length;f++){
			System.out.print(" "+datosComunes.getC()[f]+" ");
		}
		System.out.println("");
		//Espera activa (Mientras no acaben los 10 hilos no sigue)
		boolean acabar = false;
		while(!acabar){
			acabar = datosComunes.finalizar();
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//Tabla ordenada
		for(int z=0;z<datosComunes.getD().length;z++){
			System.out.print(" "+datosComunes.getD()[z]+" ");
		}		
	}

}
