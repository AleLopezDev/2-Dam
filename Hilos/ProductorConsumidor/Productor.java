package productorConsumidor;

public class Productor extends Thread {

	private Tuberia t;
	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Productor(Tuberia t) {

		this.t = t;
	}

	public void run() {

		while (true) {
			// Cooge una letra aleatoria
			char c = alfabeto.charAt((int) (Math.random() * alfabeto.length()));

			
			// Pasamos esa letra por parametro al array creado en tuberia
			t.producir(c);
			System.out.println("Introducido: " + c);
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
