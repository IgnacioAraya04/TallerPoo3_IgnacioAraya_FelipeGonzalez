package dominio;

public class HechizoAgua extends Hechizo {
	private int cantidadHeal;
	private int PresionAgua;

	public HechizoAgua(String nombre, String tipo, int daño, int cantHeal, int presionAgua) {
		super(nombre, tipo, daño);
		this.cantidadHeal = cantHeal;
		this.PresionAgua = presionAgua;
		calcularPuntaje();
	}
	
	public void calcularPuntaje() {
		setPuntaje((getDaño() + cantidadHeal +PresionAgua)*2);
	}
	
}
