package practicasTemarioGit;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerObjectBinario {

	public static void main(String[] args) throws Exception {

		ArrayList<Departamento> deps = new ArrayList<>();

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		FileInputStream finput = new FileInputStream(f);
		ObjectInputStream objInput = new ObjectInputStream(finput);

		deps = (ArrayList<Departamento>) objInput.readObject();

		objInput.close();

		for (Departamento d : deps) {
			System.out.println("Numero:" + d.getNum() + " Nombre:" + d.getNombre() + " Localizacion:" + d.getLoc());
		}
	}

}
