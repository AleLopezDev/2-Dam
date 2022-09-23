import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej08 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el nombre de fichero");
		String nom = sc.next();

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\" + File.separator + nom +  ".txt");

		FileReader fr = new FileReader(f);
		BufferedReader leer = new BufferedReader(fr); // Tanto BufferedReader como BufferedWriter depende de la clase
														// FileReader / FileWriter

		String linea;

		try {
			while ((linea = leer.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (EOFException e) {
		}

	}
}
