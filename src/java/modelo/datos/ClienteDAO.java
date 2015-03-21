package modelo.datos;

import java.util.ArrayList;

import modelo.mundo.*;

/**
 * Clase encargada de almacenar la información de los clientes en la la base de datos
 * @author juandiego
 */
public class ClienteDAO {
	
	
	/**
	 * Atributo encargado de enlazar con la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la clase ClienteDAO
	 */
	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase Cliente
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 * @return  Debe ser de tipo Cliente
	 */
	public Cliente seleccionar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete){
		
	}
	
	
	/**
	 * Metodo encargado de actualizar la información del cliente en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 * @param nCliente
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete, Cliente nCliente){
		
	}
	
	
	/**
	 * Metodo encargado de agregar un cliente a la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 * @param nCliente
	 */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete, Cliente nCliente){
		
	}
	
	
	/**
	 * Metodo encargado de eliminar un cliente de la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nTiquete
	 * @param nCliente
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Tiquete nTiquete, Cliente nCliente){
		
	}
}
