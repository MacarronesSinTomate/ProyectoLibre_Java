package Catalogo_Videojuegos;

import java.util.ArrayList;

public class Categoria {

	private String nombre;
	private ArrayList<Videojuego> videojuegos;
	
	public Categoria(String nombre) {
		this.nombre = nombre;
		this.videojuegos = new ArrayList<Videojuego>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Videojuego> getVideojuegos() {
		return videojuegos;
	}
	public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

	@Override
	public String toString() {
		return ("\n##########################" + "\nNombre: " + this.nombre + "\nJuegos contenidos: " + this.videojuegos.size() +
				"\n##########################\n");
	}
	public void listarVideojuegos() {
		
		System.out.println("\n##### Categoria " + this.nombre + " #####\n");
		
		for (Videojuego juego : this.videojuegos)
			System.out.println(juego);		
	}
	public void añadirJuego(Videojuego juego) {
		this.videojuegos.add(juego);
	}
	public void borrarJuego(String nombre) {
		
		int index = 0;
		
		for (Videojuego juego : this.videojuegos) {
			if (juego.getNombre().compareTo(nombre)==0) {
				videojuegos.remove(index);
				System.out.println("El juego ha sido eliminado :)");
				return;
			}
			index++;
		}
			
		System.out.println("El juego no ha sido eliminado :(");
	}
	public Videojuego buscarJuego(String nombre) {
		for (Videojuego juego : this.videojuegos)
			if (juego.getNombre().compareTo(nombre) == 0)
				return juego;
		
		return null;
	}
	public void buscarJuegosPorEdad(int edad) {
		for (Videojuego juego : this.videojuegos)
			if (juego.getEdadMinRecomendada() == edad)
				System.out.println(juego);
	}
	public void buscarJuegosPorDesarrollador(String nomDesarrollador) {
		for (Videojuego juego : this.videojuegos)
			if (juego.getDesarrollador().compareTo(nomDesarrollador) == 0)
				System.out.println(juego);
	}
	public void vaciarCategoria() {
		this.videojuegos.clear();
		
		System.out.println("Categoria vacia :)");
	}
}
