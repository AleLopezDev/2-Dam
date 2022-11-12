package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		// Host servidor
		final String HOST = "127.0.0.1";

		// Puerto servidor
		final int PUERTO = 5000;
		DataInputStream leer;
		DataOutputStream escribir;

		try {
			// Socket para conectarme con el servidor
			Socket sc = new Socket(HOST, PUERTO);

			leer = new DataInputStream(sc.getInputStream());
			escribir = new DataOutputStream(sc.getOutputStream());

			// Envio mensaje al servidor
			escribir.writeUTF("Hola desde el cliente");

			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
