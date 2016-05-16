package practica_5_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Proceso implements Runnable {

	private Socket clientSocket;
	private Reservas reservas;

	/*
	 * Constructor de la clase
	 */
	public Proceso(Socket socket, Reservas reservas) {
		this.clientSocket = socket;
		this.reservas = reservas;
	}

	@Override
	public void run() {
		try {
			// Inicializar los canales de comunicación usados en el
			// socket para comunicarse con el cliente.
			// El OutputStream permite enviar mensajes al cliente
			// El InputStream permite recibir al servidor
			// mensajes emitidos por el proceso cliente

			PrintWriter salidaHaciaElCliente = new PrintWriter(
					clientSocket.getOutputStream(), true);
			BufferedReader entradaDesdeElCliente = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			
			String inputLine = "";
			inputLine = entradaDesdeElCliente.readLine();
			boolean acabado = false;
			while ((inputLine != null) || (!acabado)) {
				int fila;
				int columna;
				int caso;
				// Lee el asiento solicitado
				Scanner l = new Scanner(inputLine);
				try {
					fila = l.nextInt();
					columna = l.nextInt();
				} catch (Exception e) {
					columna = -1;
					fila = -1;
				}
				// Comprueba los datos introducidos ->
				// 0 - asiento reservado 
				// 1 - asiento ocupado 
				// 2 - vagon completo 
				// 3 - datos incorrectos
				caso = reservas.hacerReserva(fila, columna);
				String respuesta;
				if (caso == 0) {
					respuesta = "Asiento reservado!";
					acabado = true;
					l.close();
				} else if (caso == 1) {
					respuesta = "Asiento ocupado, disponibles: "
							+ reservas.libres();
				} else if (caso == 2) {
					respuesta = "Vagon completo";
					acabado = true;
					l.close();
				} else {
					respuesta = "Datos incorrectos";
				}

				// Enviar la respuesta al cliente
				salidaHaciaElCliente.println(respuesta);

				// Recibir nueva petición del cliente
				inputLine = entradaDesdeElCliente.readLine();
			}

			// Al cerrar cualquiera de los canales de
			// comunicación usados por un socket, el socket se cierra.
			// Para asegurarse que se envían las respuestas que
			// están en el buffer cerramos el OutputStream.
			salidaHaciaElCliente.close();

			// Cierra el servidor de sockets
			clientSocket.close();
		} catch (Exception e) {
		}

	}

}
