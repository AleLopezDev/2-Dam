public class Libros {

	private int codigo, numeroPaginas, year;
	private String nombre, editorial, autor, genero, paisAutor, precioLibro;

	public Libros(int codigo, String nombre, String editorial, String autor, String genero, String paisAutor,
			int numeroPaginas, int year, String precioLibro) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
		this.paisAutor = paisAutor;
		this.numeroPaginas = numeroPaginas;
		this.year = year;
		this.precioLibro = precioLibro;

	}

}