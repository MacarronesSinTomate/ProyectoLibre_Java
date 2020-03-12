package Catalogo_Videojuegos;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opc = 0;
		int opc2 = 0;
		String nombreUsuario;
		String nombreCatalogo;
		
		ArrayList<Catalogo> catalogos = new ArrayList<Catalogo>();
		
		System.out.println("Introduce tu nombre: ");
		nombreUsuario = sc.nextLine();
		System.out.println("\n¡Bienvenido, " + nombreUsuario  + "!");
		System.out.println("\nVamos a crear tu primer catalogo :)");
		System.out.println("\nIntroduce el nombre de tu primer catalogo: ");
		nombreCatalogo = sc.nextLine();
		
		Catalogo catalogo =  new Catalogo(nombreCatalogo);
		
		catalogos.add(catalogo);
		
		Catalogo catalogoActivo = catalogo;
		
		do {
			//					MENU PRINCIPAL
			mostrarMenu(catalogoActivo, nombreUsuario);
			opc = Integer.parseInt(sc.nextLine());
			
			switch(opc) {
				case 1:
					añadirCatalogo(catalogos);
					break;
				case 2:
					//					  SUBMENU
					do {
						
						mostrarSubMenu(catalogoActivo, nombreUsuario);
						opc2 = Integer.parseInt(sc.nextLine());
						
						switch(opc2) {
							case 1:
								añadirCategoria(catalogoActivo);
								break;
							case 2:
								borrarCategoria(catalogoActivo);
								break;
							case 3:
								vaciarCategoria(catalogoActivo);
								break;
							case 4:
								listarCategoria(catalogoActivo);
								break;
							case 5:
								añadirJuego(catalogoActivo);
								break;
							case 6:
								borrarJuego(catalogoActivo);
								break;
							case 7:
								buscarJuegoPorNombre(catalogoActivo);
								break;
							case 8:
								buscarJuegosPorEdad(catalogoActivo);
								break;
							case 9:
								buscarJuegosPorDesarrollador(catalogoActivo);
								break;
							case 10: 
								mostrarJuegosPorCategoria(catalogoActivo);
								break;
							case 11:
								mostrarTodosVideojuegos(catalogos);
								break;
							case 12:
								System.out.println("Volviendo al menu...");
								break;
							default:
								System.out.println("La opcion introducida es incorrecta");
								break;
						}
						
					}while(opc2 != 12);
					
					break;
				case 3:
					catalogoActivo = seleccionarCatalogo(catalogos, catalogoActivo);
					break;
				case 4:
					System.out.println("Gracias por utilizar el programa :)");
					break;
				default:
					System.out.println("La opcion introducida es incorrecta");
					break;
			}
			
		}while(opc != 4);

	}

	//					  FUNCIONALIDAD
	public static void mostrarMenu(Catalogo activo, String nombre) {
		System.out.println("\n############## MENU ##############\n" + 
						   "\nUsuario: "  + nombre +
						   "\n\nCatalogo seleccionado: " + activo.getNombre() + 
						   "\n\n1.- Crear catalogo" + 
						   "\n2.- Más opciones" + 
						   "\n3.- Cambiar catálogo" +
						   "\n4.- Salir" +
						   "\n##################################\\n");
	}
	public static void mostrarSubMenu(Catalogo activo, String nombre) {
		System.out.println("\n############## SUBMENU ##############\n" + 
						   "\nUsuario: "  + nombre +
						   "\n\nCategoria seleccionada: " + activo.getNombre() + 
						   "\n\n1.- Añadir categoria" + 
						   "\n2.- Borrar categoria" + 
						   "\n3.- Vaciar categoria" +
						   "\n4.- Listar categoria" +
						   "\n5.- Añadir juego" +
						   "\n6.- Borrar juego" +
						   "\n7.- Buscar juego por nombre" +
						   "\n8.- Buscar juego por edad recomendad" +
						   "\n9.- Buscar juegos por desarrollador" +
						   "\n10.- Buscar juegos por categoria" +
						   "\n11.- Mostrar todos los juegos" +
						   "\n12.- Volver al menú principal" +
						   "\n######################################\n");
	}
	public static void listarCatalogos(ArrayList<Catalogo> catalogos) {
		for (Catalogo cat : catalogos)
			System.out.println(cat.getNombre());
	}
	
	//						   MENU
	public static void añadirCatalogo(ArrayList<Catalogo> catalogos) {
		
		String nombreCat;
		boolean existe = false;
		
		do {
			
			System.out.println("Introduce el nombre del nuevo catalogo: ");
			nombreCat = sc.nextLine();
			
			for (Catalogo cat : catalogos)
				if (cat.getNombre().compareTo(nombreCat) == 0) {
					existe = true;
					System.out.println("Ese nombre ya ha sido utilizado por otro catalogo...");
				}
					
			
		}while(existe == true);
		
		Catalogo catalogo = new Catalogo(nombreCat);
		
		catalogos.add(catalogo);
		
		System.out.println("Catalogo añadido con exito :)");
	}
	public static Catalogo seleccionarCatalogo(ArrayList<Catalogo> catalogos, Catalogo catalogoActivo) {

		listarCatalogos(catalogos);
		
		System.out.println("Introduce el nombre del catalogo: ");
		String nombre = sc.nextLine();
		for (Catalogo cat : catalogos)
			if (cat.getNombre().compareTo(nombre) == 0) {
				System.out.println("\nCatalogo cambiado :)\n");
				return cat;
			}
				
		System.out.println("No se ha podido cambiar el catalgo :(");
		return catalogoActivo;
	}
	
	//						  SUBMENU
	public static void añadirCategoria(Catalogo cat) {
		
		boolean existe = false;
		String nombre;
		do {
			
			existe = false;
			
			System.out.println("\nIntroduce el nombre de la nueva categoria: ");
			nombre = sc.nextLine();
			
			for (Categoria categoria : cat.getCategorias())
				if (categoria.getNombre().compareTo(nombre) == 0) {
					System.out.println("Ese nombre ya esta siendo utilizado :/");
					existe = true;
					break;
				}
	
		}while(existe);
		
		System.out.println("Categoria añadida correctamente :)");
		cat.añadirCategoria(nombre);
	}
	public static void borrarCategoria(Catalogo cat) {
		
		cat.listarCategorias();
		int index = 0;
		
		System.out.println("Introduce el nombre de la categoria: ");
		String nombre = sc.nextLine();
		
		for (Categoria categoria : cat.getCategorias()) {
			if (categoria.getNombre().compareTo(nombre) == 0) {
				cat.getCategorias().remove(index);
				System.out.println("Categoria borrada :)");
				return;
			}
			index++;
		}
		
		System.out.println("No se ha encontrado la categoria :(");
		return;
	}
	public static void vaciarCategoria(Catalogo cat) {
		
		cat.listarCategorias();
		
		System.out.println("Introduce el nombre de la categoria: ");
		String nombre = sc.nextLine();
		
		for (Categoria categoria : cat.getCategorias())
			if (categoria.getNombre().compareTo(nombre) == 0) {
				categoria.vaciarCategoria();
				System.out.println("Categoria vaciada con exito :)");
				break;
			}
	}
	public static void listarCategoria(Catalogo cat) {
		
		for (Categoria categoria : cat.getCategorias())
			System.out.println(categoria);
		
	}
	public static void añadirJuego(Catalogo cat) {
		
		//Seleccionas la categoria
		listarCategoria(cat);
		
		System.out.println("Introduce el nombre de la categoria: ");
		String nombre = sc.nextLine();
		Categoria categoria = cat.buscarCategoria(nombre);
		
		if(categoria != null) {
			//Dentro de la categoria te aseguras de que los datos NO son repetidos
			
			boolean existe = false;
			
			do {
				
				existe = false;
						
				System.out.println("Introduce el nombre: ");
				nombre = sc.nextLine();
				
				for ( Videojuego videojuego : categoria.getVideojuegos() )
					if (videojuego.getNombre().compareTo(nombre) == 0)
						existe = true;

			}while(existe);
			
			System.out.println("Introduce el desarrolador: ");
			String desarrollador = sc.nextLine();
			System.out.println("Introduce el precio recomendado: ");
			double precioRec = Double.parseDouble(sc.nextLine());
			System.out.println("Introduce la edad minima recomendada: ");
			int edadMinima = Integer.parseInt(sc.nextLine());
			
			//Los añades
			Videojuego nuevoJuego = new Videojuego(nombre, desarrollador, precioRec, edadMinima);
			
			categoria.añadirJuego(nuevoJuego);
			
			System.out.println("Juego añadido con exito :)");
			
		}else {
			System.out.println("Categoria no encontrda...");
		}
	}
	public static void borrarJuego(Catalogo cat) {
		
		listarCategoria(cat);
		
		System.out.println("Introduce el nombre de la categoria: ");
		String nombre = sc.nextLine();
		Categoria categoria = cat.buscarCategoria(nombre);
		
		if(categoria != null) {
			
			mostrarJuegosPorCategoria(cat);
			
			System.out.println("Introduce el nombre del juego: ");
			nombre = sc.nextLine();
				
			categoria.borrarJuego(nombre);
			
		}else {
			System.out.println("Categoria no encontrda...");
		}
		
	}
	public static void buscarJuegoPorNombre(Catalogo cat) {
		
		System.out.println("Introduce el nombre del juego: ");
		String nombre = sc.nextLine();
		
		for (Categoria categoria : cat.getCategorias()) {
			Videojuego juego = categoria.buscarJuego(nombre);
			if (juego != null) {
				System.out.println(juego);
				break;
			}
		}
		
	}
	public static void buscarJuegosPorEdad(Catalogo cat) {
		
		System.out.println("Introduce la edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		
		System.out.println("\nJuegos para edad " + edad + " o superior.\n");
		
		for (Categoria categoria : cat.getCategorias())
			categoria.buscarJuegosPorEdad(edad);
	}
	public static void buscarJuegosPorDesarrollador(Catalogo cat) {
		
		System.out.println("Introduce el nombre del desarrollador: ");
		String nombre = sc.nextLine();
		
		System.out.println("\nJuegos del desarrollador '" + nombre + "'.\n");
		
		for (Categoria categoria : cat.getCategorias())
			categoria.buscarJuegosPorDesarrollador(nombre);
		
	}
	public static void mostrarJuegosPorCategoria(Catalogo cat) {
		
		System.out.println("Introduce el nombre de la categoria: ");
		String nombre = sc.nextLine();
		
		System.out.println("\nLista de videojuegos de " + nombre + ".\n");
		
		for (Categoria categoria : cat.getCategorias())
			if (categoria.getNombre().compareTo(nombre) == 0)
				categoria.listarVideojuegos();
		
	}
	public static void mostrarTodosVideojuegos(ArrayList<Catalogo> cat) {

		System.out.println("\nLista de todos los videojuegos.\n");
		
		for (Catalogo catalogo : cat) {
			System.out.println("\nCatalogo: " + catalogo.getNombre() + "\n");
			for (Categoria categoria : catalogo.getCategorias()) {
				categoria.listarVideojuegos();
			}	
		}
	}
}