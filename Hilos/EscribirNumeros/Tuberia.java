package EjercicioPractica;

public class Tuberia {

	public void comprobarCola(int numConexiones) {

		while (numConexiones < 3) {
			try {
				System.out.println("En espera");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Este se ejecuta");

	}

}
