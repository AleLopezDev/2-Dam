package EjercicioREY;

public class Tuberia {

	public boolean hallegado = false;

	public synchronized void saludar(Thread hilo) {

		System.out.println("Hilo entrando " + hilo.getName() + " con prioridad " + hilo.getPriority());
		asignarPrioridad(hilo);

		while (hilo.getPriority() < 5) {

			try {
				wait(); // Aqui se quedan esperando los soldados y despues continuan con el codigo de
						// abajo

				asignarPrioridad(hilo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		hallegado = true;

		System.out.println("El hilo " + hilo.getName() + " tiene prioridad " + hilo.getPriority());
		System.out.println("El " + hilo.getName() + " saluda");

		notifyAll(); // Notifica a los demas que pueden continuar su ejecucion

	}

	private void asignarPrioridad(Thread hilo) {
		if (hallegado) {
			hilo.setPriority(5);
			System.out.println("Se le ha asignado una priorida al " + hilo.getName() + " de " + hilo.getPriority());
		}
	}

}
