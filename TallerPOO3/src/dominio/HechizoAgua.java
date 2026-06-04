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
	
	@Override
	public void setEspecial1(int cantidadheal) {
		this.cantidadHeal = cantidadheal;
	}
	
	public void setEspecial2(int presion) {
		this.PresionAgua = presion;
	}
	
	public void calcularPuntaje() {
		setPuntaje((getDaño() + cantidadHeal +PresionAgua)*2);
	}
	@Override
	public String formatoTxt() {
		return getNombre()+";Agua;"+getDaño()+";"+cantidadHeal+","+PresionAgua;
	}
	
	@Override
	public String toString() {
		
		return getNombre() + "| Tipo: "+ getTipo()+"| Daño: "+ getDaño()+"| Curación: "+ cantidadHeal +"| Presion de agua: "+PresionAgua;
	}
}
