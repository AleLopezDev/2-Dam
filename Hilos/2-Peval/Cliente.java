package peval2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	static Scanner sc = new Scanner(System.in);
	static int opcionSeleccionada = 0;

	public static void main(String[] args) {
		final int PUERTO = 5200;

		try {
			Socket cliente = new Socket("localhost", PUERTO);
			System.out.println("Te has conectado al servidor");

			DataOutputStream escribir = new DataOutputStream(cliente.getOutputStream());
			DataInputStream leer = new DataInputStream(cliente.getInputStream());

			while (opcionSeleccionada != 9) {

				// Recibe las opciones disponibles enviadas por el servidor
				System.out.println(leer.readUTF());

				// Envia el numero al servidor
				opcionSeleccionada = sc.nextInt();
				escribir.writeInt(opcionSeleccionada);

				String opcionRecibida = leer.readUTF();
				System.out.println(opcionRecibida);

			}
			
			cliente.close();
			escribir.close();
			leer.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
