package Examen7yMedia;

import java.net.Socket;

public class HiloMultiServidor implements Runnable {

	Tuberia t;
	Socket cliente;
	boolean seguirJugando = true;

	public HiloMultiServidor(Tuberia t, Socket cliente) {
		this.t = t;
		this.cliente = cliente;
	}

	@Override
	public void run() {
		String nombre = Thread.currentThread().getName();
		while (seguirJugando == true) {
			t.llegarCola(cliente, nombre);
			seguirJugando = t.recibirCarta(cliente, nombre);
			t.bancaJuega(cliente,nombre);
		}
	}

}
