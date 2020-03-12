package Catalogo_Videojuegos;

import java.util.ArrayList;

public class Catalogo {

	private String nombre;
	private ArrayList<Categoria> categorias;
	
	public Catalogo(String nombre) {
		this.nombre = nombre;
		this.categorias = new ArrayList<Categoria>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public void añadirCategoria(String nombre) {	
		Categoria nuevaCat = new Categoria(nombre);
		this.categorias.add(nuevaCat);
	}
	public void borrarCategoria(String nombre) {
		
		int index = 0;
		
		for (Categoria cat : this.categorias) {
			if(cat.getNombre().compareTo(nombre) == 0)
				this.categorias.remove(index);
			index++;
		}
		
		System.out.println("Categoria eliminada :)");
	}
	public Categoria buscarCategoria(String nombre) {
		for (Categoria cat : this.categorias)
			if (cat.getNombre().compareTo(nombre) == 0 )
				return cat;
		
		return null;
	}
	public void listarCategorias() {
		for (Categoria cat : this.categorias)
			System.out.println(cat);
	}
}
