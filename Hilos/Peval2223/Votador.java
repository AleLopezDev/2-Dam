package peval2223;

public class Votador extends Thread {

	Tuberia t;

	public Votador(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		t.votar(this.getName());

	}
}
