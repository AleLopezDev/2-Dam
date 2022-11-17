package EjercicioPractica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	static int numConexiones = 0;

	public static void main(String[] args) {
		final int PUERTO = 5200;
		ServerSocket servidor;
		Socket sc;
		DataInputStream lectura;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while (numConexiones < 3) {
				// System.out.println("Esperando usuario...");

				sc = new Socket();
				sc = servidor.accept();
				System.out.println("Usuario Conectado");

				lectura = new DataInputStream(sc.getInputStream());

				HiloMultiServidor h = new HiloMultiServidor(sc, numConexiones);
				Thread  t = new Thread(h);
				t.start();
				numConexiones++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
