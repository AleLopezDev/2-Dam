package ExamenJunio;

public class Hilo implements Runnable {

	int capacidadActual = 0;
	int capacidadMaxima;
	Tuberia t = new Tuberia();

	public Hilo(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			capacidadActual =  t.rellenarBotella(capacidadActual);
			System.out.println(capacidadActual);
		}
	}

}
