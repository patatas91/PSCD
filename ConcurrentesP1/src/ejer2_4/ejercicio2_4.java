package ejer2_4;


/**
* @author Cristian Simon Moreno
* @NIP: 611487
*/

class ejercicio2_4 implements Runnable{

    /**
    * El atributo veces almacena un valor de tipo entero (int). 
    * El atributo nombre almacena un valor de tipo String
    */	
    private int veces;
    private String nombre;

   /** 
    * Define el constructor de objetos ejercicio2_1 especificándole el valor de los 
    * atributos veces y nombre.    
    */
    public ejercicio2_4(int v, String n){         
    	this.veces = v;
    	this.nombre = n;
    }


    /** 
     * Devuelve void. 
     * Cuando se llama al método run de un thread se realiza su ejecución. Salvando las diferencias,
     * el método run() es similar al método main() pero para clases que descienden de la clase Thread.
     * Cuando finaliza la ejecución del método run() el thread muere.	
     * En este caso la ejecución del método run() consiste en imprimir el nombre del Thread un numero
     * definido de veces.	
     */
    public void run(){
    	
		while(veces!=0){			
			System.out.println("Soy "+nombre);
			veces = veces - 1;
		}
    }
    
    public static void main(String args[]) throws InterruptedException{

        Thread t1,t2,t3;
        ejercicio2_4 r1,r2,r3;
	 
        //Creamos los objetos Runnable
        r1 = new ejercicio2_4 (10, "A");
        r2 = new ejercicio2_4 (15, "B");
        r3 = new ejercicio2_4 (9, "C");

       //Creamos los threads para que se ejecuten los 
       //objetos Runnable
       t1 = new Thread(r1);
       t2 = new Thread(r2);
       t3 = new Thread(r3);

       //Arrancamos los threads       
       t1.start();
       Thread.sleep(100);
       t2.start();
       Thread.sleep(100);
       t3.start();  
       Thread.sleep(100);
   }   
    
}