package practica_5_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Proceso implements Runnable {

	private Socket clientSocket;

	/*
	 * Constructor de la clase
	 */
	public Proceso(Socket socket) {
		this.clientSocket = socket;
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

			// Contar las vocales de las frases enviadas por el cliente
			String inputLine = "";
			inputLine = entradaDesdeElCliente.readLine();

			while ((inputLine != null) && (!inputLine.equals("FINAL SERVICIO"))) {
				// Calcular el número de vocales que
				// tiene la respuesta.
				String respuesta = "Número de vocales: "
						+ calculaNumeroVocales(inputLine);

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

	private static int calculaNumeroVocales(String frase) {
		int resultado = 0;
		for (int i = 0; i < frase.length(); i++) {
			if ((frase.charAt(i) == 'a') || (frase.charAt(i) == 'e')
					|| (frase.charAt(i) == 'i') || (frase.charAt(i) == 'o')
					|| (frase.charAt(i) == 'u') || (frase.charAt(i) == 'A')
					|| (frase.charAt(i) == 'E') || (frase.charAt(i) == 'I')
					|| (frase.charAt(i) == 'O') || (frase.charAt(i) == 'U')) {
				resultado++;
			}
		}
		return resultado;
	}

}
