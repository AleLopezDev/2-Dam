import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ej05_leer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DepartamentoS d;
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		FileInputStream fIn = new FileInputStream(f);
		ObjectInputStream objInput = new ObjectInputStream(fIn);
		int i;

		try {
			while (true) {
				d = (DepartamentoS) objInput.readObject();
				System.out.println(d.getNum() + d.getNombre() + d.getLoc());
			}
		} catch (EOFException e) {
		}
	}

}
