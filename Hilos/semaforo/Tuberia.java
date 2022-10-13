package semaforo;

import java.util.ArrayList;

public class Tuberia {

	private String[] orden = { "Verde", "Amarilla", "Roja" };
	ArrayList<String> hilosEnOrden = new ArrayList<String>();

	int i = 0;
	boolean acabado = false;

	public synchronized void encender(String nombreHilo) {

		// Cuando se complete el array con los 3 colores se vuelve a 0, debido al bucle while(true)
		if (hilosEnOrden.size() == 3) {
			i = 0;
			hilosEnOrden.clear();
		}

		while (nombreHilo != orden[i]) {

			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Se ha encendido la luz " + nombreHilo);
		hilosEnOrden.add(nombreHilo);
		notifyAll();

	}

	public synchronized void apagar(String nombreHilo) {

		while (hilosEnOrden.get(i) != nombreHilo) {
			try {
				System.out.println(hilosEnOrden.get(i));
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Se ha apagado la luz " + nombreHilo);
		i++;
		notifyAll();
		System.out.println();

	}

	public boolean isAcabado() {
		return acabado;
	}

	public void setAcabado(boolean acabado) {
		this.acabado = acabado;
	}

}
