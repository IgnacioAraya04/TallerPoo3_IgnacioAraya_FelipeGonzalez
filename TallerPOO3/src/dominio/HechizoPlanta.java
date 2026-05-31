package dominio;

public class HechizoPlanta extends Hechizo {

	private int duracionStun;
	private int cantidadPlanta;

	public HechizoPlanta(String nombre, String tipo, int daño, int ds, int cantPlanta) {
		super(nombre, tipo, daño);
		this.duracionStun = ds;
		this.cantidadPlanta = cantPlanta;
		calcularPuntaje();
	}

	public void calcularPuntaje() {
		setPuntaje(getDaño() + (duracionStun * cantidadPlanta));
	}
}
