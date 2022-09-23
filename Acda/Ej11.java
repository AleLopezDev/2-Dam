import java.util.Scanner;
import java.io.*;

public class Ej11 {

	Scanner sc = new Scanner(System.in);
	FileWriter fw;

	public static void main(String[] args) throws IOException {

		copiarFicheros("nuevoArchivo1.txt", "C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Copia\\Copia1.txt",
				"C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Copia");
		
		copiarFicheros("nuevoArchivo2.txt", "C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Copia\\Copia2.txt",
				"C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Copia");
	}

	public static void copiarFicheros(String nombre, String origen, String destino) throws IOException {
		File f = new File(origen);

		// Leer
		FileReader fr = new FileReader(f);
		BufferedReader leer = new BufferedReader(fr);

		// Escribir
		FileWriter fw = new FileWriter(destino + File.separator + nombre);
		BufferedWriter escribir = new BufferedWriter(fw);

		String i;
		while ((i = leer.readLine()) != null) {

			escribir.write(i);

		}

		leer.close();
		escribir.close();

	}

}
