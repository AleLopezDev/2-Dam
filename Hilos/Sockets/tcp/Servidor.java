package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket scServidor;
		Socket sc;
		DataInputStream leer;
		final int PUERTO = 5000;

		try {
			scServidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			// Siempre escuchando peticiones
			while (true) {

				// Esperamos a que un cliente se conecte
				sc = scServidor.accept();
				leer = new DataInputStream(sc.getInputStream());

				// Leemos el mensaje que envia el cliente
				String mensaje = leer.readUTF();
				System.out.println(mensaje);

				sc.close();
				System.out.println("Cliente desconectado");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
