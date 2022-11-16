package EjercicioPractica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloMultiServidor extends Thread {

	Socket s;
	Tuberia t;
	DataInputStream lectura;
	DataOutputStream escritura;
	int numConexiones = 0;

	public HiloMultiServidor(Socket cliente, int numConexiones) {

		try {
			escritura = new DataOutputStream(cliente.getOutputStream());
			lectura = new DataInputStream(cliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.numConexiones = numConexiones;
		this.s = cliente;
	}

	public HiloMultiServidor(Tuberia t) {
		this.t = t;
	}

	@Override
	public void run() {

	}

}
