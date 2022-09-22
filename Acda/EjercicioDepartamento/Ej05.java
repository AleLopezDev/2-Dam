
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej05 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectouput = new ObjectOutputStream(fileout);

		for (int i = 0; i < 2; i++) {

			System.out.println("Introduce el numero de departamento: ");
			int n = sc.nextInt();

			System.out.println("Introduce el nombre");
			String nombre = sc.next();

			System.out.println("introduce la loc: ");
			String loc = sc.next();

			objectouput.writeObject(new DepartamentoS(n, nombre, loc));
		}

		objectouput.close();

	}

}
