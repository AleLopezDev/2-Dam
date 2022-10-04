package DOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Ej15 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\XML\\universidades.xml");

		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = miFactoria.newDocumentBuilder();
		Document documento = constructor.parse(f);

		System.out.println(documento.getDocumentElement().getNodeName());
		System.out.println("-----------------------------");

		NodeList nList = documento.getElementsByTagName("departamento"); // Sale 3 porque hay 3 departamentos
		for (int i = 0; i < nList.getLength(); i++) {

			Node nodo = nList.item(i);
			Element e1 = (Element) nodo;
			System.out.println("Departamento: " + e1.getAttribute("tipo"));

			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				NodeList listaHijos = e.getChildNodes();

				System.out.println("Codigo - " + e.getTextContent());
				System.out.println("Nombre - " + e.getTextContent());
				System.out.println("Salario empleado - " + e.getAttribute("salario"));

				

			}

			System.out.println();

		}

	}

}
