package practica_5_3;

public class Reservas {	
	
	// True->ocupado, False->libre
	private boolean[][] vagon;
	private int ocupados;

	/*
	 * Constructor de la clase
	 */
	public Reservas() {
		vagon = new boolean[10][4];
		ocupados = 0;
	}

	/**
	 * True si el asiento [fila][columna] esta ocupado
	 * 
	 * @param fila
	 * @param columna
	 */
	public boolean ocupado(int fila, int columna) {
		return vagon[fila][columna];
	}

	/**
	 * Devuelve true si el vagon esta lleno
	 */
	public boolean lleno() {
		return ocupados == 40;
	}

	/**
	 * Devuelve X si el asiento esta ocupado o O si el asiento esta libre
	 */
	public String marca(int fila, int columna) {
		if (vagon[fila][columna]) {
			return "X";
		} else
			return "O";
	}

	/**
	 * Devuelve un grafico con los asientos libres y ocupados del vagon
	 */
	public String libres() {
		String resultado = "";
		for (int i = 0; i <= 9; i++) {
			resultado = resultado + "Fila " + (i + 1) + ":" + marca(i, 0) + marca(i, 1)
					+ marca(i, 2) + marca(i, 3);
		}
		return resultado;
	}

	/**
	 * Metodo sincronizado para realizar la reserva de un asiento 
	 * 0 - asiento reservado 
	 * 1 - asiento ocupado 
	 * 2 - vagon completo 
	 * 3 - datos incorrectos
	 */
	synchronized int hacerReserva(int fila, int columna)
			throws InterruptedException {
		// 3 - datos incorrectos
		if (fila < 1 || fila > 10 || columna < 1 || columna > 4) {
			return 3;
		} else {
			// 2 - vagon completo
			if (lleno()) {
				return 2;
			}
			// 0 - asiento reservado
			else if (!ocupado(fila - 1, columna - 1)) {
				vagon[fila - 1][columna - 1] = true;
				ocupados++;
				notifyAll();
				return 0;
			}
			// asiento ocupado
			else {
				return 1;
			}
		}
	}

}
