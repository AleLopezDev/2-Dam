import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Tareas {

	private static Scanner sc = new Scanner(System.in);
	private Statement sentencia;

	public Tareas(Statement sentencia) {
		this.sentencia = sentencia;
	}

	/**
	 * Ejercicio 1 Método que permite transformar una bd sql a neodatis
	 */
	public void transformarNeodatis() {

		// Ruta que se pide: D:\peval3acda2223

		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde quieres guardar la bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		if (f.exists()) {
			f.delete();
		}

		ODB odb = ODBFactory.open(f.getAbsolutePath()); // Abrir BD

		try {
			ResultSet libros = sentencia.executeQuery("Select * from libros");

			while (libros.next()) {
				odb.store(new Libros(libros.getInt(1), libros.getString(2), libros.getString(3), libros.getString(4),
						libros.getString(5), libros.getString(6), libros.getInt(7), libros.getInt(8),
						libros.getString(9)));
			}

			ResultSet usuario = sentencia.executeQuery("select * from usuario");

			while (usuario.next()) {
				Usuario u = new Usuario(usuario.getInt(1), usuario.getString(2), usuario.getString(3),
						usuario.getString(4), usuario.getString(5), usuario.getString(6), usuario.getString(7),
						usuario.getString(8));
				odb.store(u);
			}

			ResultSet prestamos = sentencia.executeQuery("select * from prestamos");

			while (prestamos.next()) {

				// Buscamos el codigo de libro y recuperamos el libro con dicho codigo para
				// posteriormente meterlo
				CriteriaQuery consultaCodigo = new CriteriaQuery(Libros.class,
						Where.equal("codigo", prestamos.getInt(2)));
				Objects<Libros> libro = odb.getObjects(consultaCodigo);
				Libros l = (Libros) libro.getFirst();

				CriteriaQuery consultaUsuario = new CriteriaQuery(Usuario.class,
						Where.equal("codigoUsuario", prestamos.getInt(3)));
				Objects<Usuario> user = odb.getObjects(consultaUsuario);
				Usuario u = (Usuario) user.getFirst();

				odb.store(new Prestamos(prestamos.getInt(1), l, u, prestamos.getString(4), prestamos.getString(5),
						prestamos.getString(6)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		odb.close();
	}

	/*
	 * Ejercicio 2
	 */
	public void altaLibros() throws SQLException {

		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde quieres guardar la bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");

		ODB odb = ODBFactory.open(f.getAbsolutePath());

		Values val3 = odb.getValues(new ValuesCriteriaQuery(Libros.class).max("codigo"));
		ObjectValues v = val3.next();
		BigDecimal codLibro = (BigDecimal) (v.getByIndex(0));

		System.out.println("Introduce el nombre de libro:");
		String nombre = sc.nextLine();

		System.out.println("Introduce la editorial: ");
		String editorial = sc.nextLine();

		System.out.println("Nombre Autor: ");
		String nAutor = sc.nextLine();

		System.out.println("Pais Autor: ");
		String pais = sc.nextLine();

		System.out.println("Número de paginas");
		int nPaginas = sc.nextInt();

		System.out.println("Año de edicion");
		int year = sc.nextInt();

		sc.nextLine();

		System.out.println("Precio Libro");
		String precioLibro = sc.nextLine();

		odb.store(new Libros(codLibro.intValue() + 1, nombre, editorial, nAutor, pais, nAutor, nPaginas, year,
				precioLibro));
		System.out.println("\nLibro insertado con exito");

		odb.close();

	}
	/*
	 * Ejercicio 3 - Baja de Usuarios
	 */

	public void bajaUsuarios() {

		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde se encuentra bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		ODB odb = ODBFactory.open(f.getAbsolutePath());

		System.out.println("Introduce el nombre a borrar");
		String name = sc.next();

		System.out.println(name);

		// Borramos primero el prestamo para despues poder borrar el usuario
		CriteriaQuery borradoPrestamo = new CriteriaQuery(Prestamos.class, Where.equal("Usuario.nombre", "Jose"));
		Objects<Prestamos> prestamos = (Objects<Prestamos>) odb.getObjects(borradoPrestamo).getFirst();
		if(prestamos.hasNext()) {
			System.out.println("Existe");
		}else {
			System.out.println("No esxa");
		}

		CriteriaQuery borrado = new CriteriaQuery(Usuario.class, Where.equal("nombre", "Jose"));
		Objects<Usuario> usuario = odb.getObjects(borrado);

		if (usuario.hasNext()) {
			Usuario u = (Usuario) odb.getObjects(borrado).getFirst();
			odb.delete(u);
		} else {
			System.out.println("No existe");
		}

		odb.close();
	}

}
