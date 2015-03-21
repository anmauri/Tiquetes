package modelo.datos;

import java.util.ArrayList;

import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Vehiculo;


/**
 * Clase encargada de almacenar informacion de las lineas de las marcas en la base de datos
 */
public class LineaDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachadaDB;
	
	
	/**
	 * Metodo constructor de la clase LineaDAO
	 */
	public LineaDAO(){
		
	}
	
	
	/**
	 * Lista almacenadora de objetos de tipo Marca
	 * @param nMarca
	 * @return
	 */
	public ArrayList<Linea> seleccionar(Marca nMarca){
	
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
         * @param vNombre 
	 */
	public void actualizar(Marca nMarca, Linea nLinea, String vNombre){
	
	}
	
	
	/**
	 * Metodo encargado de agregar una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 */
	public void agregar(Marca nMarca, Linea nLinea){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 */
	public void eliminar(Marca nMarca, Linea nLinea){
		
	}
}