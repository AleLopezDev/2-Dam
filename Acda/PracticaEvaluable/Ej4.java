package peval1acda2223;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;

import ejerciciosdepartamentoObjeto.Departamento;

public class Ej4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Investor i;

		// Lectura
		ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(
				new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\practicaEvaluable\\investor.txt")));

		// Escritura
		ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(
				new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\practicaEvaluable\\companies.XML")));

		try {
			while (true) {
				i = (Investor) lectura.readObject();
				System.out.println(i.getCodigo() + ";" + i.getCompany() + ";" + i.getName() + ";" + i.getSurname() + ";"
						+ i.getCalidad() + ";" + i.getType());

			}
		} catch (EOFException e) {
		}

		lectura.close();
		escribir.close();
	}

	public static void escribirXML(Investor i) throws ParserConfigurationException {

		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); // Definicion de la factoria DOM
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); // Definicion del Constructor Dom
		DOMImplementation implementacion = miConstructor.getDOMImplementation(); // Interfaz DOM

		// Creacion del documento
		Document miDocumento = implementacion.createDocument(null, "clientes", null);
		miDocumento.setXmlVersion("1.0");

		// Creacion de la primera etiqueta
		Element companies = miDocumento.createElement("companies");
		
		// Creacion de la etiqueta investors
		Element investors = miDocumento.createElement("investors");
		
		// Creacion de la etiqueta investor
		
		Element investor = miDocumento.createElement("investor");
		investor.setAttribute("type", null);

	}
}
