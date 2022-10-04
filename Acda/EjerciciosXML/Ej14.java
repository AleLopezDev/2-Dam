package DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.*;

public class Ej14 {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); // Definicion de la factoria DOM
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); // Definicion del Constructor Dom
		DOMImplementation implementacion = miConstructor.getDOMImplementation(); // Interfaz DOM

		// Creacion del documento
		Document miDocumento = implementacion.createDocument(null, "universidad", null);
		miDocumento.setXmlVersion("1.0");

			// Primer departamento
			Element dep = miDocumento.createElement("departamentos");
			dep.setAttribute("telefono", "436");
			dep.setAttribute("tipo", "C");
			

			// Primer Elemento dentro de departamento
			Element cod = miDocumento.createElement("codigo");
			Text textoCod = miDocumento.createTextNode("Cod-222");
			cod.appendChild(textoCod);
			dep.appendChild(cod);
	
			// Segundo Elemento
			Element nombre = miDocumento.createElement("nombre");
			Text textoNombre = miDocumento.createTextNode("Olivos");
			nombre.appendChild(textoNombre);
			dep.appendChild(nombre);
			
			// Tercer Elemento
			Element empleado1 = miDocumento.createElement("empleado");
			empleado1.setAttribute("salario", "1000 €");
			
			
				// Elementos dentro del tercer Elemento
				Element puesto1 = miDocumento.createElement("puesto");
				Text textoPuesto1 = miDocumento.createTextNode("Jefe");
				puesto1.appendChild(textoPuesto1);
				empleado1.appendChild(puesto1);
				
				Element nombre1 = miDocumento.createElement("nombre");
				Text nombre1Texto = miDocumento.createTextNode("Recluta");
				nombre1.appendChild(nombre1Texto);
				empleado1.appendChild(nombre1);
				
			
			// Cuarto Elemento
			
			Element empleado2 = miDocumento.createElement("empleado");	
			empleado2.setAttribute("salario", "3200 €");
			
				// Elementos dentro del cuarto Elemento
			
				Element puesto2 = miDocumento.createElement("puesto");
				Text textoPuesto2 = miDocumento.createTextNode("Jefe");
				puesto2.appendChild(textoPuesto2);
				empleado2.appendChild(puesto2);
				
				Element nombre2 = miDocumento.createElement("nombre");
				Text nombre2Texto = miDocumento.createTextNode("Recluta");
				nombre2.appendChild(nombre2Texto);
				empleado2.appendChild(nombre2);
				
				
				
				
				
			
			dep.appendChild(empleado1);
			dep.appendChild(empleado2);
			miDocumento.getDocumentElement().appendChild(dep);
			
			
			//Creación y grabación del fichero
			Source source = new DOMSource(miDocumento);
			Result resultado = new StreamResult(new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\XML\\Universidad.XML"));
			Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
			miTransformer.transform(source, resultado);
				
				
				
	}
}
