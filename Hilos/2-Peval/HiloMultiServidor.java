package peval2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloMultiServidor implements Runnable {

	Socket s;
	DataInputStream lectura;
	DataOutputStream escritura;
	int opcionSeleccionada = 0;

	public HiloMultiServidor(Socket cliente) {

		try {
			escritura = new DataOutputStream(cliente.getOutputStream());
			lectura = new DataInputStream(cliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.s = cliente;

	}

	@Override
	public void run() {

		long tiempoInicio = System.currentTimeMillis();

		String mensaje = "Elige el tipo de consulta a realizar:\n1 - Futurología\n2 - Meeting\n3 - Compras\nTeclee opcion: ";
		try {

			// Enviamos el mensaje con todas las opciones
			escritura.writeUTF(mensaje);

			opcionSeleccionada = lectura.readInt();

			while (opcionSeleccionada != 9) {

				switch (opcionSeleccionada) {

				case 1:
					escritura.writeUTF("Has seleccionado Futurología");
					break;
				case 2:
					escritura.writeUTF("Has seleccionado Meeting");
					break;
				case 3:
					escritura.writeUTF("Has seleccionado Compras");
					break;
				}

				// Volvemos a enviar al cliente el menu de opciones
				escritura.writeUTF(mensaje);

				// Volvemos a recuperar la opcion seleccionada
				opcionSeleccionada = lectura.readInt();
			}

			// Enviamos un mensaje al usuario informando que ha sido desconectado
			escritura.writeUTF("Has sido desconectado del servidor con éxito");
		
			
			// El servidor recibe que el cliente ha sido desconectado e imprime el tiempo de
			// conexion
			System.out.println("\nCliente desconectado");

			long tiempoConectado = (System.currentTimeMillis() - tiempoInicio) / 1000;
			System.out.println("\tTiempo conectado: " + tiempoConectado + " sg ");

			lectura.close();
			escritura.close();
			s.close();
			
			// System.out.println(s.toString());

			/*
			System.out.println("Datos de conexion: ");
			// System.out.println("\nPuerto local del usuario" + s.getLocalPort());
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
