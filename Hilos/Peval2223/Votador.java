
public class Votador extends Thread {

	Tuberia t;

	public Votador(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

		t.entrarEnCola(this.getName());

		t.checkearCenso(this.getName());

		//t.respetarCola(this.getName());

		try {
			sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//t.votar(this.getName());

	}
}