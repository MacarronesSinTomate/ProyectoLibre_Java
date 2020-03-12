package Catalogo_Videojuegos;

public class Videojuego {

	private String nombre;
	private String desarrollador;
	private double precioRecomendado;
	private int edadMinRecomendada;
	//private Date fechaLanzamiento;
	
	public Videojuego(String nombre, String desarrollador, double precio, int edadMin) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.precioRecomendado = precio;
		this.edadMinRecomendada = edadMin;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	public double getPrecioRecomendado() {
		return precioRecomendado;
	}
	public void setPrecioRecomendado(double precioRecomendado) {
		this.precioRecomendado = precioRecomendado;
	}
	public int getEdadMinRecomendada() {
		return edadMinRecomendada;
	}
	public void setEdadMinRecomendada(int edadMinRecomendada) {
		this.edadMinRecomendada = edadMinRecomendada;
	}
	
	public String toString() {
		return ("\n##########################" + "\nNombre: " + this.nombre + "\nDesarrollador" + this.desarrollador +
				"\nPrecio recomendado: " + this.precioRecomendado + "\nEdad minima recomendada: " + this.edadMinRecomendada +
				"\n##########################\n");
	}
}
