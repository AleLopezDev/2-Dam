package factorial;

public class Hilo extends Thread {

	int resultado = 1;
	int numero;

	@Override
	public void run() {

		for (int i = numero; i > 1; i--) {

			resultado = i * resultado;
			System.out.println(resultado);

		}

	}

	public void pasarParamentor(int valor) {
		this.numero = valor;
	}

}
