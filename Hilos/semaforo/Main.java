package semaforo;

public class Main {

	private static Tuberia t = new Tuberia();

	public static void main(String[] args) {

		Luz verde = new Luz(t);
		verde.setName("Verde");

		Luz amarilla = new Luz(t);
		amarilla.setName("Amarilla");

		Luz roja = new Luz(t);
		roja.setName("Roja");
		
		Tiempo tiempo = new Tiempo(t);

		tiempo.start();
		verde.start();
		amarilla.start();
		roja.start();

	}

}
