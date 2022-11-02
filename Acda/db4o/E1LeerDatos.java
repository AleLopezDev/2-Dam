package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1LeerDatos {

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile("C:\\Users\\usuario\\Documents\\db4o\\Personas.yap");

		Persona p = new Persona();		
		ObjectSet<Persona> result = db.queryByExample(p);
		while(result.hasNext()) {
			p = result.next();
			System.out.println("Nombre = " + p.getNombre() + p.getCiudad());
		}
		
		
		// Buscar por nombre específico (Juan)
		Persona Juan = new Persona("Juan", null);
		ObjectSet<Persona> resultJuan = db.queryByExample(Juan);
		while(resultJuan.hasNext()) {
			p = resultJuan.next();
			System.out.println(Juan.getNombre());
		}
		
		
		
		// SIEMPRE CERRAR
		db.close();
	}
}
