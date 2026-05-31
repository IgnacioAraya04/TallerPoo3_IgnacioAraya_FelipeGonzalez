package dominio;

import java.util.ArrayList;

public class Mago {
	
	private String nombre;
	private ArrayList<Hechizo> listaHechizos;
	
	public Mago(String nombre, ArrayList<Hechizo> listaHechizos) {
		super();
		this.nombre = nombre;
		this.listaHechizos = listaHechizos;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}
	
	
}
