package productorConsumidor;

public class Consumidor extends Thread {

	Tuberia t;

	public Consumidor(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		while (true) {

			// Observar letra recogida
			char c = t.consumir();
			System.out.println("Letra consumida " + c);

			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
