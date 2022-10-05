package peval1acda2223;

import java.io.File;

public class Busqueda {
	boolean existe = false;
	String ruta;

	public Busqueda() {

	}

	public boolean busquedaArchivo(File f) {
		File[] listaArchivos = f.listFiles();

		if (listaArchivos != null) {
			for (File i : listaArchivos) {
				if (i.getName().equals("Companies.txt")) {
					System.out.println();
					System.out.println("Companies existe y esta en la ruta: " + i);
					existe = true;
					ruta = i.getPath();
				}
				busquedaArchivo(i);
			}

		}

		return existe;

	}

	public String devolverRuta() {
		return ruta;
	}

}
