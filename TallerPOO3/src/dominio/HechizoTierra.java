package dominio;

public class HechizoTierra extends Hechizo {

	private int mejoraDefensa;
	
		public HechizoTierra(String nombre, String tipo, int daño, int mejoraDefensa) {
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
		calcularPuntaje();
	}
		
	public void calcularPuntaje() {
		setPuntaje((getDaño() * mejoraDefensa)/2);
	}
}
