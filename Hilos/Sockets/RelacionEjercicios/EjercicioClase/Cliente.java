package EjercicioPractica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	static Scanner sc = new Scanner(System.in);

	public Cliente() {

	}

	public static void main(String[] args) {
		final int PUERTO = 5200;

		try {
			Socket cliente = new Socket("localhost", PUERTO);
			System.out.println("Cliente conectado");

			DataOutputStream escribir = new DataOutputStream(cliente.getOutputStream());
			DataInputStream lectura = new DataInputStream(cliente.getInputStream());

			int numeroCone = lectura.readInt();
			

			while (numeroCone == 2) {

				System.out.println("Escribe un numero: ");
				String numeroEscrito = sc.nextLine();

				// Envia el numero al servidor
				escribir.writeUTF(numeroEscrito);
			}

			cliente.close();
			lectura.close();
			escribir.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
