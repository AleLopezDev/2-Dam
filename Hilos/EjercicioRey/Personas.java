package EjercicioREY;

public class Personas extends Thread {

	Tuberia t;

	public Personas(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		t.saludar(this);

	}

}
