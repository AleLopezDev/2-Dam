package db4o;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1BorrarDatos {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\usuario\\Documents\\db4o\\Personas.yap");
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());

		Persona p = new Persona("Manuel", "Cordoba");
		ObjectSet<Persona> result = db.queryByExample(p);

		if (result.hasNext()) {
			p = result.next();
			db.delete(p);
		}

		db.close();
	}
}
