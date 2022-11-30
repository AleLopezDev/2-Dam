package Examen7yMedia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	static Tuberia tuberia = new Tuberia();
	static int i = 0;
	static DataOutputStream escribir;
	static DataInputStream leer;

	public static void main(String[] args) throws IOException {
		ServerSocket sc = new ServerSocket(5200);
		Socket cliente;

		while (true) {
			i++;
			cliente = sc.accept();

			escribir = new DataOutputStream(cliente.getOutputStream());
			escribir.writeInt(i);

			System.out.println("Usuario conectado");

			HiloMultiServidor h = new HiloMultiServidor(tuberia, cliente, i);
			Thread t = new Thread(h);
			t.setName(String.valueOf(i));
			t.start();

		}
	}

}
