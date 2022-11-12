
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente {

	public static void main(String[] args) {

		// puerto del servidor
		final int PUERTO_SERVIDOR = 5000;
		// buffer donde se almacenara los mensajes
		byte[] buffer = new byte[1024];

		try {

			// Obtengo mi direccion
			InetAddress direccionServidor = InetAddress.getLocalHost();

			// Creo el socket UDP
			DatagramSocket socketUDP = new DatagramSocket();

			String mensaje = "HOLA MUNDO DESDE EL CLIE";

			// Convierto el mensaje a bytes
			buffer = mensaje.getBytes();

			// Creo un datagram
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			System.out.println("Mensaje enviado");
			socketUDP.send(pregunta);

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
