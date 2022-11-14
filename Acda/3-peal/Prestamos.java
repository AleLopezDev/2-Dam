
public class Prestamos {

	int numeroPedido;
	Libros Libro;
	Usuario Usuario;
	String fechaSalida, fechaMaxDevolucion, fechaDevolucion;

	public Prestamos(int numeroPedido, Libros Libro, Usuario Usuario, String fechaSalida, String fechaMaxDevolucion,
			String fechaDevolucion) {
		this.numeroPedido = numeroPedido;
		this.Libro = Libro;
		this.Usuario = Usuario;
		this.fechaSalida = fechaSalida;
		this.fechaMaxDevolucion = fechaMaxDevolucion;
		this.fechaDevolucion = fechaDevolucion;
	}

}
