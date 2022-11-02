package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class E1Principal {

	public static void main(String[] args) {

		ObjectContainer db = Db4oEmbedded.openFile("C:\\Users\\usuario\\Documents\\db4o\\Personas.yap");
		// Creamos E1Personas
		Persona p1 = new Persona("Juan", "Guadalajara");
		Persona p2 = new Persona("María", "Madrid");
		Persona p3 = new Persona("Enrique", "Málaga");
		Persona p4 = new Persona("Manuel", "Sevilla");
		Persona p5 = new Persona("Manuel", "Cordoba");
		
		// Almacenar objetos Persona en la base de datos
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		db.store(p5);

		// Cerramos la base de datos
		db.close();
	}
}