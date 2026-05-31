package dominio;

public class Hechizo {
	private String nombre;
	private String tipo;
	private int daño;
	private int puntaje;

	public Hechizo(String nombre, String tipo, int daño) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getDaño() {
		return daño;
	}
	
	

}
