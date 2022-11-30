package Examen7yMedia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	static DataInputStream leer;
	static DataOutputStream escribir;
	static Scanner scanner = new Scanner(System.in);
	static String respuesta = "";
	static boolean enEscucha = true;

	public static void main(String[] args) throws IOException {
		Socket sc = new Socket("localhost", 5200);

		leer = new DataInputStream(sc.getInputStream());
		escribir = new DataOutputStream(sc.getOutputStream());

		// Recibe el numero de conexiones
		int numConexiones = leer.readInt();
		
		System.out.println("Numero conexones" + numConexiones);
		if (numConexiones < 4) {

			while (!respuesta.equalsIgnoreCase("n")) {

				// Puntos obtenidos
				System.out.println(leer.readUTF());

				// Enviamos la respuesta de si otra carta
				respuesta = scanner.next();
				escribir.writeUTF(respuesta);

				// Si no ha salido indicamos que esta en espera
				if (respuesta.equalsIgnoreCase("s")) {
					System.out.println(leer.readUTF());
				} else {
					// Leemos los puntos que tenemos
					System.out.println(leer.readUTF());
				}
			}

			leer.close();
			escribir.close();
			sc.close();
		} else {
			leer.close();
			escribir.close();
			sc.close();
		}

	}
}
