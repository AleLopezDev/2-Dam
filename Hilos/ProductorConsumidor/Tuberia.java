package productorConsumidor;

public class Tuberia {

	private char[] array;
	private int siguiente;
	private boolean estaVacio, estaLLeno;

	public Tuberia(int size) {

		this.array = new char[size];
		this.siguiente = 0;
		this.estaVacio = true;
		this.estaLLeno = false;
	}

	public synchronized char consumir() {

		while (estaVacio) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Al consumir nos vamos uno atras
		siguiente--;
		estaLLeno = false;
		
		
		// No existe mas
		if (siguiente == 0) {
			estaVacio = true;
		}
		
		// Notifica al siguiente hilo que puede continuar
		notify();
		return array[siguiente];
		
	

	}

	public synchronized void producir(char c) {

		// Mientras este lleno esperamos
		while (estaLLeno) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Añadimos letras al array y declaramos que ya no esta vacio
		array[siguiente] = c;
		siguiente++;
		estaVacio = false;

		// Si siguiente es igual a la longitud del array, quiere decir que esta lleno
		if (siguiente == array.length) {
			estaLLeno = true;
		}

		// Todos los hilos esperando pueden continuar
		notify();

	}
}
