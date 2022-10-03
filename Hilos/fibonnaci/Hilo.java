package fibonnaci;

public class Hilo extends Thread {

	int numero, resultado = 0;

	public void run() {

		for (int i = 0; i <= numero; i++) {

			resultado = resultado + i;
			System.out.println(resultado);

		}

	}

	public void parametro(int parametro) {
		this.numero = parametro;

	}

}
