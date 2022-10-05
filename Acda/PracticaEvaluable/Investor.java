package peval1acda2223;

import java.io.Serializable;

public class Investor implements Serializable {

	private int codigo;
	private char company;
	private String name, surname, calidad, type;

	public Investor(int codigo, char company, String name, String surname, String calidad, String type) {

		this.codigo = codigo;
		this.name = name;
		this.surname = surname;
		this.calidad = calidad;
		this.type = type;

	}

	public Investor() {

	}

}
