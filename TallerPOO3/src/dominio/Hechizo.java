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

	public String getTipo() {
		return tipo;
	}
	
	public String formatoTxt() {
		return null;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public void setEspecial1(int s) {
		
	}
	public void setEspecial2(int s) {
		
	}

	public String toString() {
		return null;
	}
	
	
}
