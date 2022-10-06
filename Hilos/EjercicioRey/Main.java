package EjercicioREY;

public class Main {

	static Tuberia t = new Tuberia();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personas rey = new Personas(t);
		rey.setName("Rey");

		Personas sol1 = new Personas(t);
		sol1.setName("Soldado 1");

		Personas sol2 = new Personas(t);
		sol2.setName("Soldado 2");

		Personas sol3 = new Personas(t);
		sol3.setName("Soldado 3");

		rey.setPriority(5);
		sol1.setPriority(1);
		sol2.setPriority(1);
		sol3.setPriority(1);

		rey.start();
		sol3.start();
		sol2.start();
		sol1.start();
		

	}

}
