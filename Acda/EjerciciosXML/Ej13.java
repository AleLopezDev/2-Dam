package DOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ej13 {

	public static void main(String[] args) throws ParserConfigurationException, Exception, IOException {

		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();

		Document miDocument = miConstructor
				.parse(new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\XML\\Clientes.XML"));

		System.out.println("Archivo: " + miDocument.getDocumentElement().getNodeName());

		NodeList listaClientes = miDocument.getElementsByTagName("clientes");

		System.out.println("---------------------------------------");

		for (int i = 0; i < listaClientes.getLength(); i++) {

			Node nodo = listaClientes.item(i);

			System.out.println("Nodo actual: " + nodo.getNodeName()); // Primer Cliente

			if (nodo.getNodeType() == Node.ELEMENT_NODE) { // Si contiene mas archivos dentro

				Element e = (Element) nodo;

				System.out.println("Nombre " + e.getElementsByTagName("nombre").item(0).getTextContent());
				System.out.println("Poblacion " + e.getElementsByTagName("poblacion").item(0).getTextContent());
				System.out.println("Telefono " + e.getElementsByTagName("telefono").item(0).getTextContent());
				System.out.println("Direccion " + e.getElementsByTagName("direccion").item(0).getTextContent());

			}

		}

	}

}
