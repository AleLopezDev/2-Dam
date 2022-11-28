public void crearXML()
			throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException {

		LibrosRetraso l;
		File f = new File("C:\\EXAMENACDA2021\\sanciones.dat");
		ObjectInputStream leerObjeto = new ObjectInputStream(new FileInputStream(f));

		Document miDocumento = null;
		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); // Definicion de la factoria DOM
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); // Definicion del Constructor Dom
		DOMImplementation implementacion = miConstructor.getDOMImplementation();

		try {

			// Creacion del documento
			miDocumento = implementacion.createDocument(null, "sanciones", null);
			miDocumento.setXmlVersion("1.0");

			while (true) {
				l = (LibrosRetraso) leerObjeto.readObject();

				Element usuarios = miDocumento.createElement("usuarios");

				Element usuario = miDocumento.createElement("usuario");
				usuario.setAttribute("retraso", "xxx");

				Element nombreUsuario = miDocumento.createElement("nombreUsuario");
				Text valorNombreUsuario = miDocumento.createTextNode(l.getNombreUsuario());
				nombreUsuario.appendChild(valorNombreUsuario);

				Element apellidoUsuario = miDocumento.createElement("apellidoUsuario");
				Text valorApellido = miDocumento.createTextNode(l.getApellidosUsuario());
				apellidoUsuario.appendChild(valorApellido);

				Element nombreLibro = miDocumento.createElement("nombreLibro");
				Text valorNombreLibro = miDocumento.createTextNode(l.getNombreLibro());
				nombreLibro.appendChild(valorNombreLibro);

				usuario.appendChild(nombreUsuario);
				usuario.appendChild(apellidoUsuario);
				usuario.appendChild(nombreLibro);

				usuarios.appendChild(usuario);
				miDocumento.getDocumentElement().appendChild(usuarios);

			}
		} catch (EOFException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Source source = new DOMSource(miDocumento);
		Result resultado = new StreamResult(new File("C:\\EXAMENACDA2021\\ficheroXML.xml"));
		Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
		miTransformer.transform(source, resultado);

		System.out.println("Archivo creado correctamente");

	}

	public void leerXML() {

		try {

			DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); // Definicion de la factoria DOM
			DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();
			Document documento = miConstructor
					.parse(new File("C:\\Users\\Alex\\Documents\\ficherosAcda\\universidad.xml"));
			DOMImplementation implementacion = miConstructor.getDOMImplementation();

			NodeList listaDepartamentos = documento.getElementsByTagName("departamento");

			for (int i = 0; i < listaDepartamentos.getLength(); i++) {

				Node nodo = listaDepartamentos.item(i);
				System.out.println(nodo.getNodeName());

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;

					// Recogemos atributo
					System.out.println("Telefono: " + elemento.getAttribute("telefono"));
					System.out.println("Tipo: " + elemento.getAttribute("tipo"));

					System.out.println("Codigo: " + elemento.getElementsByTagName("codigo").item(0).getTextContent());
					System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());

					
					
					//  NODO EMPLEADO DENTRO DE OTRO
					
					NodeList nEmpleado = elemento.getElementsByTagName("empleado");
					for (int k = 0; k < nEmpleado.getLength(); k++) {
						Node nodoEmpleado = nEmpleado.item(k);

						if (nodoEmpleado.getNodeType() == Node.ELEMENT_NODE) {
							
							Element empElemento = (Element) nodoEmpleado;
							System.out.println("Salario: " + empElemento.getAttribute("salario"));
							System.out.println("Puesto: " + empElemento.getElementsByTagName("puesto").item(0).getTextContent());
							System.out.println("Nombre: " + empElemento.getElementsByTagName("nombre").item(0).getTextContent());

							System.out.println("\n-------------");
						}
					}

					System.out.println(nEmpleado.getLength());
					// Element empleado = (Element)
					// elemento.getElementsByTagName("empleado").item(0);

					System.out.println("\n-----------------------------");
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Definicion del Constructor Dom
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
