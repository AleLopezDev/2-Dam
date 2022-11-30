package Examen7yMedia;

import java.net.Socket;

public class HiloMultiServidor implements Runnable {

	Tuberia t;
	Socket cliente;
	boolean seguirJugando = true;
	private int conexiones;

	public HiloMultiServidor(Tuberia t, Socket cliente, int i) {
		this.t = t;
		this.cliente = cliente;
		this.conexiones = i;
	}

	@Override
	public void run() {
		String nombre = Thread.currentThread().getName();
		
		t.esperarConexion(conexiones);
		
		while (seguirJugando == true) {
			t.llegarCola(cliente, nombre);
			seguirJugando = t.recibirCarta(cliente, nombre);
			t.bancaJuega(cliente, nombre);
		}
	}

}
