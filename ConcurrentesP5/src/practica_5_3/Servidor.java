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
 * Com:     Implementa un servidor que atiende a un único cliente. Procesa cadenas de
 *          texto que le envía (cuenta su número de vocales), hasta que llega una concreta
 *          para marcar la intención de cerrar la conexión.
 *          Material suministrado para la práctica 5 de PSCD, Universidad de Zaragoza
 */

package practica_5_3;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		int SERVER_PORT = 32002;
		// Inicializar el socket donde escucha el servidor en
		// local y en el puerto SERVER_PORT

		// Objeto para las reservas
		Reservas reservas = new Reservas();

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			System.err.println("Problemas en puerto: " + SERVER_PORT);
			System.exit(1);
		}
		Socket clientSocket = null;
		Proceso p = null;
		Thread hilo = null;
		while (true) {
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.exit(1);
			}
			// Crea un Thread por cada peticion del cliente
			p = new Proceso(clientSocket, reservas);
			hilo = new Thread(p);
			hilo.start();
		}
	}
}