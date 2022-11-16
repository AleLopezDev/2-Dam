import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
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
		String name = sc.nextLine();

		CriteriaQuery comprobarNombre = new CriteriaQuery(Usuario.class, Where.equal("nombre", name));
		Objects<Usuario> nombre = odb.getObjects(comprobarNombre);

		// Si existe
		if (nombre.hasNext()) {
			// Borramos primero el prestamo para despues poder borrar el usuario
			CriteriaQuery borradoPrestamo = new CriteriaQuery(Prestamos.class, Where.equal("Usuario.nombre", name));
			Objects<Prestamos> listaPrestamos = odb.getObjects(borradoPrestamo);
			while (listaPrestamos.hasNext()) {
				Prestamos p = listaPrestamos.next();
				// p = (Prestamos) odb.getObjects(borradoPrestamo).getFirst();
				odb.delete(p);
			}

			// Borramos los usuarios
			CriteriaQuery borrado = new CriteriaQuery(Usuario.class, Where.equal("nombre", name));
			Objects<Usuario> listaUsuarios = odb.getObjects(borrado);
			while (listaUsuarios.hasNext()) {
				Usuario u = listaUsuarios.next();
				// u = (Usuario) odb.getObjects(borrado).getFirst();
				odb.delete(u);
			}

			System.out.println("Usuario y sus prestamos borrados con éxito\n");

		} else {
			System.out.println("No existe\n");
		}

		odb.close();
	}

	public void modificarPrestamo() {
		Prestamos p = null;

		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde se encuentra bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		ODB odb = ODBFactory.open(f.getAbsolutePath());

		// Imprimimos la lista de prestamos
		CriteriaQuery consultaPrestamos = new CriteriaQuery(Prestamos.class);
		Objects<Prestamos> listaPrestamos = odb.getObjects(consultaPrestamos);
		while (listaPrestamos.hasNext()) {
			p = (Prestamos) listaPrestamos.next();
			System.out.println(p);
		}

		// Obtenemos
		System.out.println("Elija  prestamo: ");
		int nPrestamo = sc.nextInt();
		CriteriaQuery nombrePrestamo = new CriteriaQuery(Prestamos.class, Where.equal("numeroPedido", nPrestamo));
		Objects<Prestamos> prestamoSeleccionado = odb.getObjects(nombrePrestamo);
		if (prestamoSeleccionado.hasNext()) {
			System.out.println("Prestamo seleccionado actualmente: " + nPrestamo);
			p = prestamoSeleccionado.getFirst();
		} else {
			System.out.println("No existe ese prestamo");
		}

		// Mostramos un menu con las opciones para cambiar
		System.out.println(
				"1 - Cambiar Usuario\n2 - Cambiar Libro\n3 - Fecha Salida\n4 - Fecha Max Devolucion\n5 - Fecha Devolucion");
		int opcionSeleccionada = sc.nextInt();

		sc.nextLine();
		switch (opcionSeleccionada) {

		case 1:
			System.out.println("Introduce el nombre de Usuario: ");
			String nombreUsuario = sc.nextLine();
			CriteriaQuery consultaNombre = new CriteriaQuery(Usuario.class, Where.equal("nombre", nombreUsuario));
			Objects<Usuario> listaUsuarios = odb.getObjects(consultaNombre);
			while (listaUsuarios.hasNext()) {
				Usuario u = (Usuario) listaUsuarios.next();
				System.out.println(u);
				p.setUsuario(u);
				odb.store(p);
				System.out.println("Modificacion realizada con exito");
			}
			break;
		case 2:
			System.out.println("Introduce el nombre del Libro: ");
			String nombreLibro = sc.nextLine();
			CriteriaQuery consultaLibro = new CriteriaQuery(Libros.class, Where.equal("nombre", nombreLibro));
			Objects<Libros> listaLibros = odb.getObjects(consultaLibro);
			while (listaLibros.hasNext()) {
				Libros l = (Libros) listaLibros.next();
				System.out.println(l);
				p.setLibro(l);
				odb.store(p);
				System.out.println("Modificacion realizada con exito");
			}
			break;
		case 3:
			System.out.println("Introduce la fecha de salida nueva");
			String fechaSalida = sc.nextLine();
			p.setFechaSalida(fechaSalida);
			break;

		case 4:
			System.out.println("Introduce la fecha maxima de devolucion: ");
			String fechaMaximaDevolucion = sc.nextLine();
			p.setFechaMaxDevolucion(fechaMaximaDevolucion);
			break;
		case 5:
			System.out.println("Introduce la fecha de devolucion");
			String fechaDevol = sc.nextLine();
			p.setFechaMaxDevolucion(fechaDevol);
			break;
		}

		odb.close();
	}

	/**
	 * Ejercicio 5
	 * 
	 * @throws ParseException
	 */
	public static void prestamosRetraso() throws ParseException {
		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde se encuentra bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		ODB odb = ODBFactory.open(f.getAbsolutePath());

		// Imprimir lista usuarios
		System.out.println("Lista de usuarios: ");
		CriteriaQuery consultaUsuario = new CriteriaQuery(Usuario.class);
		Objects<Usuario> listaUsuarios = odb.getObjects(consultaUsuario);
		while (listaUsuarios.hasNext()) {
			Usuario u = listaUsuarios.next();
			System.out.println(u);
		}
		System.out.println("Introduce el codigo usuario: ");
		int codUsuario = sc.nextInt();

		// Escoger Prestamo
		CriteriaQuery consultaPrestamo = new CriteriaQuery(Prestamos.class,
				Where.equal("Usuario.codigoUsuario", codUsuario));
		Objects<Prestamos> listaPrestamos = odb.getObjects(consultaPrestamo);

		// Comparamos si la fecha de Devolucion viene despues de la fecha maxima
		// permitida
		while (listaPrestamos.hasNext()) {
			Prestamos p = (Prestamos) listaPrestamos.next();
			Date fechaMax = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaMaxDevolucion());
			Date fechaDev = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaDevolucion());

			if (fechaDev.after(fechaMax)) {
				System.out.println("El prestamo con id: " + p.getNumeroPedido() + " esta entregado con retraso ");
			}
		}
		System.out.println();

		odb.close();
	}

	/**
	 * Ejercicio 6
	 * 
	 * @throws ParseException
	 */
	public static void libroGenero() throws ParseException {
		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde se encuentra bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		ODB odb = ODBFactory.open(f.getAbsolutePath());

		System.out.println("Introduce el genero del libro: ");
		String genero = sc.nextLine();

		System.out.println("Introduce el precio tope: ");
		double precioTope = sc.nextInt();

		CriteriaQuery consultaLibro = new CriteriaQuery(Libros.class, Where.equal("genero", genero));
		Objects<Libros> listaLibros = odb.getObjects(consultaLibro);

		while (listaLibros.hasNext()) {
			Libros l = listaLibros.next();
			String precio = "";
			// 2.256,00 - Caballeresco
			// 674,00 - Novela
			if (l.getPrecioLibro().contains(".")) {
				precio = l.getPrecioLibro().replace(".", "");
			} else if (l.getPrecioLibro().contains(",")) {
				precio = l.getPrecioLibro().replace(",", ".");
			}

			if (Double.parseDouble(precio) < precioTope) {
				System.out.println("Precio del libro: " + l.getPrecioLibro());
				System.out.println("El libro " + l.getCodigo() + " tiene un precio inferio al tope");
			}
		}
		System.out.println("\n\n");
		sc.nextLine();
		odb.close();
	}

	/**
	 * @throws ParseException
	 * 
	 */
	public static void prestamosRealizados() throws ParseException {


		// Al usar linux, pido la ruta donde quiere ser introducido el archivo
		System.out.println("Introduce la ruta donde se encuentra bibliotecas.neo");
		String ruta = sc.nextLine();

		// Archivo donde se va guardar la biblioteca.neo
		// File f = new File(ruta + File.separator + "biblioteca.neo");
		File f = new File("/home/alex/ficheros/biblioteca.neo");
		ODB odb = ODBFactory.open(f.getAbsolutePath());

		System.out.println("Introduce la provicia: ");
		String provincia = sc.nextLine();

		System.out.println("Introduce la fecha de inicio: ");
		String fechaInicio = sc.nextLine();

		System.out.println("Introduce la fecha de fin: ");
		String fechaFin = sc.nextLine();

		ICriterion consulta = new And().add(Where.equal("Usuario.provincia", provincia));

		IQuery query = new CriteriaQuery(Prestamos.class, consulta);
		Objects<Prestamos> lista = odb.getObjects(query);

		// Parseamos a date las fechas pedidas
		Date inicioPedida = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
		Date finPedida = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);

		while (lista.hasNext()) {
			Prestamos p = lista.next();

			Date fechaSalida = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaSalida());
			Date fechaDevol = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaDevolucion());

			if (inicioPedida.after(fechaSalida) && finPedida.before(fechaDevol)) {
				System.out.println(p);
			}
		}
	}
}