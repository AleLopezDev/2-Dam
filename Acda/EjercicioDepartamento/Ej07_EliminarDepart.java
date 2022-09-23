package ejerciciosdepartamento;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej07_EliminarDepart {

	static Departamento d;

	public static void main(String[] args) throws IOException, Exception {

		Scanner sc = new Scanner(System.in);
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");

		// Lectura
		FileInputStream fw = new FileInputStream(f);
		ObjectInputStream lectura = new ObjectInputStream(fw);

		// Escritura
		FileOutputStream fo = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\DepartTemporal.dat");
		ObjectOutputStream escritura = new ObjectOutputStream(fo);

		System.out.println("Introduce el departamento a borrar : ");
		int nDep = sc.nextInt();

		try {
			while (true) {
				d = (Departamento) lectura.readObject(); // Lee un departamento
				if (!(d.getNum() == nDep)) {
					escritura.writeObject(d);
				}

			}
		} catch (EOFException e) {
		}

		lectura.close();
		escritura.close();
		renombrar();
	}

	public static void renombrar() throws IOException, Exception {

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\DepartTemporal.dat");

		// Lectura de fichero
		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream lectura = new ObjectInputStream(fr);

		// Escritura
		FileOutputStream fw = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		ObjectOutputStream escribir = new ObjectOutputStream(fw);

		try {
			while (true) {
				d = (Departamento) lectura.readObject(); // Lee un departamento del fichero temporal
				escribir.writeObject(d);
			}

		} catch (EOFException e) {
		}

		lectura.close();
		escribir.close();
		f.delete();

	}
}
