package Examen1Eval;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Cliente {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Host servidor
		final String HOST = "127.0.0.1";

		// Puerto servidor
		final int PUERTO = 5000;
		DataInputStream leer;
		DataOutputStream escribir;

		try {
			// Socket para conectarme con el servidor
			Socket cliente = new Socket(HOST, PUERTO);

			leer = new DataInputStream(cliente.getInputStream());
			escribir = new DataOutputStream(cliente.getOutputStream());

			String cadena = "";
			while (!cadena.equals("ñ")) {
				System.out.println("DILE ALGO AL SERVIDOR");
				cadena = sc.nextLine();

				escribir.writeUTF(cadena);

			}
			leer.close();
			escribir.close();
			cliente.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
