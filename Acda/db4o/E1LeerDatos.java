package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1LeerDatos {

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile("C:\\Users\\usuario\\Documents\\db4o\\Personas.yap");

		Persona p = new Persona();
		ObjectSet<Persona> result = db.queryByExample(p);
		while (result.hasNext()) {
			p = result.next();
			System.out.println("Nombre = " + p.getNombre() + " Ciudad: " + p.getCiudad());
		}

		// Buscar por nombre específico (Juan)
		ObjectSet<Persona> resultJuan = db.queryByExample(new Persona("Manuel", null));
		System.out.println("\n");
		while (resultJuan.hasNext()) {
			p = resultJuan.next();
			System.out.println(p.getNombre());
		}

		// Buscar por ciudad específica
		System.out.println("\nPersonas que viven en Madrid");
		ObjectSet<Persona> resultMadrid = db.queryByExample(new Persona(null, "Madrid"));

		while (resultMadrid.hasNext()) {
			p = resultMadrid.next();
			System.out.println("Nombre: " + p.getNombre() + " Ciudad: " + p.getCiudad());
		}

		// SIEMPRE CERRAR
		db.close();
	}
}
