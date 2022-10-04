package DOM;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


public class Ej12 {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); // Definicion de la factoria DOM
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); // Definicion del Constructor Dom
		DOMImplementation implementacion = miConstructor.getDOMImplementation(); // Interfaz DOM

		// Creacion del documento
		Document miDocumento = implementacion.createDocument(null, "clientes", null);
		miDocumento.setXmlVersion("1.0");

		// Primer cliente
		Element cliente = miDocumento.createElement("cliente");
		cliente.setAttribute("numero", "XX");

		// Primer Elemento dentro de cliente
		Element nombre = miDocumento.createElement("nombre");
		Text textoNombre = miDocumento.createTextNode("Alejandro");
		nombre.appendChild(textoNombre);
		cliente.appendChild(nombre);

		// Segundo elemento dentro de cliente
		Element poblacion = miDocumento.createElement("poblacion");
		Text textoPoblacion = miDocumento.createTextNode("Malaga");
		poblacion.appendChild(textoPoblacion);
		cliente.appendChild(poblacion);

		// Tercer elemento dentro de cliente
		Element telefono = miDocumento.createElement("telefono");
		Text textoTelefono = miDocumento.createTextNode("6111");
		telefono.appendChild(textoTelefono);
		cliente.appendChild(telefono);

		// Cuarto elemento dentro de cliente
		Element direccion = miDocumento.createElement("direccion");
		Text textoDireccion = miDocumento.createTextNode("Carlos Haya");
		direccion.appendChild(textoDireccion);
		cliente.appendChild(direccion);

		miDocumento.getDocumentElement().appendChild(cliente);

		// Creación y grabación del fichero
		Source source = new DOMSource(miDocumento);
		Result resultado = new StreamResult(new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\XML\\Clientes.xml"));
		Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
		miTransformer.transform(source, resultado);

	}
}
