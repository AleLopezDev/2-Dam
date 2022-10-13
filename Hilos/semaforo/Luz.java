package semaforo;

public class Luz extends Thread {

	Tuberia t;

	public Luz(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		while (t.isAcabado() == false) {
			t.encender(getName());

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			t.apagar(getName());
		}

	}

}
