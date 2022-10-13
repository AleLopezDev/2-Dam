package semaforo;

public class Tiempo extends Thread {

	Tuberia t;
	int i = 0;

	public Tiempo(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		while (i < 60) {
			i++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		t.setAcabado(true);
		System.out.println(t.isAcabado());

	}
}
