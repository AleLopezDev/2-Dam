
import java.util.ArrayList;
import java.util.Arrays;

public class Tuberia {

	int x = 0, i = 0;
	private Integer[] listaDnis = { 1, 2, 3, 4, 6, 8, 10, 11, 13, 14, 15, 18, 19, 20, 22, 23, 24, 28, 29, 30 };
	private ArrayList<Integer> colaCenso = new ArrayList<>();
	private ArrayList<Integer> colaVotar = new ArrayList<>();

	public void entrarEnCola(String name) {

		if (Arrays.asList(listaDnis).contains(Integer.parseInt(name))) {
			System.out.println("Votador " + name + " ha entrado a la cola");
			colaCenso.add(Integer.parseInt(name));
		}

	}

	public synchronized void checkearCenso(String nombre) {



			if (Arrays.asList(listaDnis).contains(Integer.parseInt(nombre))) {

				while (colaCenso.get(x) != Integer.parseInt(nombre)) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				x++;
				notifyAll();
				System.out.println(nombre + " ha checkeado el censo");
			}
		

	}

	public synchronized void votar(String nombre) {

	}

	public void imprimirCola() {

		if (colaCenso.size() == 0) {
			for (int i : colaCenso) {
				System.out.println(i);
			}
		}
	}

	public void respetarCola(String name) {

	}

	public synchronized void realizarVoto(String nombre) {

		System.out.println("El votador " + nombre + " ha votado");

	}

}