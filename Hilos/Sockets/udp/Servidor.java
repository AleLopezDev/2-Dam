
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;

public class Servidor {

	final static int PUERTO = 5000;
	ServerSocket scServer;

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		try {
			System.out.println("Iniciando el servidor UDP");
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);

			// Creamos una peticion para que nos envie el usuario
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

			// Es lo mismo que el readUTF
			socketUDP.receive(peticion);
			System.out.println("Recibo la peticion del cliente");

			// Guardamos el mensaje
			String mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			
			
			socketUDP.close();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
