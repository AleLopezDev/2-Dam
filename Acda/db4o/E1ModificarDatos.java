package db4o;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1ModificarDatos {

	public static void main(String[] args) {

		File f = new File("C:\\Users\\usuario\\Documents\\db4o\\Personas.yap");
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());

		Persona p = new Persona("Manuel", null);
		ObjectSet<Persona> result = db.queryByExample(p);

		// Comprobar si existe una persona con el Nombre Manuel, si existe cambia el
		// primer Manuel que encuentre
		if (result.hasNext()) {
			System.out.println("Existe el nombre");
			p = result.next();

			p.setCiudad("Barcelona");
			db.store(p);
		} else {
			System.out.println("No existe");
		}

		// Si añadimos p = new Persona("Manuel","Cordoba"), cambiara unicamente a Manuel de cordoba

		db.close();

	}

}
