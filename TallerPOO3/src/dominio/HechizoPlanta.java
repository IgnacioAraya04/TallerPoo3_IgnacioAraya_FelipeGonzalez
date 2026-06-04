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
	@Override
	public void setEspecial1(int dStun) {
		this.duracionStun = dStun;
	}
	
	public void setEspecial2(int cPlantas) {
		this.cantidadPlanta = cPlantas;
	}

	public void calcularPuntaje() {
		setPuntaje(getDaño() + (duracionStun * cantidadPlanta));
	}
	@Override
	public String formatoTxt() {
		return getNombre()+";Planta;"+getDaño()+";"+duracionStun+","+cantidadPlanta;
	}
	
	@Override
	public String toString() {
		
		return getNombre() + "| Tipo: "+ getTipo()+"| Daño: "+ getDaño()+"| Duración del Stun: "+ duracionStun +"| Cantidad de plantas: "+cantidadPlanta;
	}

}
