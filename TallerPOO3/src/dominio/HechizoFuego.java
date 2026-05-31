package dominio;

public class HechizoFuego extends Hechizo {

	private int duracionQuemadura;

	public HechizoFuego(String nombre, String tipo, int daño, int dq) {
		super(nombre, tipo, daño);
		this.duracionQuemadura = dq;
		calcularPuntaje();
	}
	
	public void calcularPuntaje() {
		setPuntaje(getDaño()*duracionQuemadura);
	}

}
