package dominio;

public class HechizoTierra extends Hechizo {

	private int mejoraDefensa;
	
		public HechizoTierra(String nombre, String tipo, int daño, int mejoraDefensa) {
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
		calcularPuntaje();
	}
		public void setEspecial1(int mDefensa) {
			this.mejoraDefensa = mDefensa;
		}
		
	public void calcularPuntaje() {
		setPuntaje((getDaño() * mejoraDefensa)/2);
	}
	@Override
	public String formatoTxt() {
		return getNombre()+";Tierra;"+getDaño()+";"+mejoraDefensa;
	}

	@Override
	public String toString() {
		
		return getNombre() + "| Tipo: "+ getTipo()+"| Daño: "+ getDaño()+"| Mejora de defensa: "+ mejoraDefensa;
	}

	
}
