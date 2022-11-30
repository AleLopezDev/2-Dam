package Examen7yMedia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Tuberia {

	Baraja b = new Baraja();

	DataOutputStream escribir;
	DataInputStream leer;
	int jug = 0;

	private ArrayList<Socket> jugadores = new ArrayList<>();
	private double[] puntosJugadores = new double[20];
	private boolean[] haAcabado = new boolean[20];

	public void llegarCola(Socket cliente, String nombre) {
		jugadores.add(cliente);
	}

	public boolean recibirCarta(Socket cliente, String nombre) {

		System.out.println("Ha entrado el hilo " + nombre);

		synchronized (this) {

			while (jugadores.get(0) != cliente) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {

				escribir = new DataOutputStream(cliente.getOutputStream());
				leer = new DataInputStream(cliente.getInputStream());

				String carta = b.extraerCarta();
				Double puntos = puntosJugadores[Integer.parseInt(nombre)] + b.obtenerPuntos(carta);
				escribir.writeUTF("Turno de Jugador (ID): " + nombre + "\nHas recibido: " + carta
						+ "\nPUNTOS ACTUALES: " + puntos + "\n¿Quieres otra carta? (S/N): ");

				String respuesta = leer.readUTF();

				if (respuesta.equalsIgnoreCase("s")) {
					carta = b.extraerCarta();
					puntos = puntos + b.obtenerPuntos(carta);
					puntosJugadores[Integer.valueOf(nombre)] = puntos;
					escribir.writeUTF(carta + "\nPUNTOS ACTUALES: " + puntos
							+ "\nEstas en espera... Turno del siguiente jugador\n");
					jugadores.remove(0);
					notifyAll();
					return true;
				} else if (respuesta.equalsIgnoreCase("n")) {
					escribir.writeUTF("\nPUNTOS ACTUALES: " + puntos);
					puntosJugadores[Integer.valueOf(nombre)] = puntos;
					haAcabado[Integer.valueOf(nombre)] = true;
					jugadores.remove(0);
					jug--;
					notifyAll();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;
		}

	}

	public void bancaJuega(Socket cliente, String nombre) {
	
	}

}
