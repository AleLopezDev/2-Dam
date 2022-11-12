package Examen1Eval;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket scServidor;
		Socket cliente;
		DataInputStream leer;
		final int PUERTO = 5000;

		try {
			scServidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			// Siempre escuchando peticiones
			while (true) {

				// Esperamos a que un cliente se conecte
				cliente = scServidor.accept();
				leer = new DataInputStream(cliente.getInputStream());

				HiloServidorCliente s = new HiloServidorCliente(cliente);
				Thread t = new Thread(s);
				t.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
