/*
 * 
 * @author Cristian Simon Moreno - NIP: 611487
 * 
 * File:    Servidor.java
 *
 * Version: V1.0
 *
 * Date:    Noviembre 2013
 *
 * Com:     Implementa un servidor que atiende a un �nico cliente. Procesa cadenas de
 *          texto que le env�a (cuenta su n�mero de vocales), hasta que llega una concreta
 *          para marcar la intenci�n de cerrar la conexi�n.
 *          Material suministrado para la pr�ctica 5 de PSCD, Universidad de Zaragoza
 */

package practica_5_2;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		int SERVER_PORT = 32001;
		// Inicializar el socket donde escucha el servidor en
		// local y en el puerto SERVER_PORT
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			System.err.println("Problemas en puerto: " + SERVER_PORT);
			System.exit(1);
		}

		// Inicializar el socket del cliente con el que se va a
		// comunicar el servidor, es decir se acepta la
		// conexi�n de un cliente al servidor mediante
		// el m�todo accept()
		Socket clientSocket = null;
		Proceso p = null;
		Thread hilo = null;
		// Se queda esperando conexiones
		while (true) {
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			// Crea un Thread por cada peticion del cliente
			p = new Proceso(clientSocket);
			hilo = new Thread(p);
			hilo.start();
		}
	}
}