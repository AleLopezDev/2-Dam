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
		DataOutputStream escritura;
		DataInputStream lectura;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while (numConexiones < 3) {
				// System.out.println("Esperando usuario...");

				sc = new Socket();
				sc = servidor.accept();
				System.out.println("Usuario Conectado");

				escritura = new DataOutputStream(sc.getOutputStream());
				escritura.writeInt(numConexiones);
				
				lectura = new DataInputStream(sc.getInputStream());
				

				HiloMultiServidor h = new HiloMultiServidor(sc, numConexiones);
				h.start();
				numConexiones++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
