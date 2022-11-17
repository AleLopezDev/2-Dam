package peval2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static int conexiones = 0;

	public static void main(String[] args) throws IOException {
		final int PUERTO = 5200;
		ServerSocket servidor;
		Socket sc;
		DataInputStream lectura;

		servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado");

		// Arreglar las conexiones

		if (conexiones < 3) {

			while (true) {

				// Este va a ser el cliente
				sc = new Socket();
				sc = servidor.accept();
				System.out.println("Usuario Conectado");
				// conexiones++;

				HiloMultiServidor h = new HiloMultiServidor(sc);
				Thread t = new Thread(h);
				t.start();
			}
		}

	}
}
