package modelo.mundo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

import modelo.datos.MarcaDAO;


/**
 * clase prinsipal del programa esta clase se encarga del manjo de los  requerimientos y la informacion del hotel
 * @author megasoft 
 */
public class RutasSuroccidente {
	
	
	/**
	 * atributo encargado del manejo de las marcas en la base de datos
	 */
	private MarcaDAO marcaDAO;
	
	
	/**
	 * la lista de marcas
	 */
	private ArrayList<Marca> marcas;
	
	
        private static RutasSuroccidente instancia;
	//-------------------------------------------------------------------------------------------
	//Constructor
	//-------------------------------------------------------------------------------------------
	
	public static RutasSuroccidente darInstancia(){
            if(instancia==null){
                instancia= new RutasSuroccidente();
            }
            return instancia;
        }
        
	/**
	 * metodo constructor de la calse RutasSuroccidente
	 * <b>post:</b> se ha construido una intancia de la clase RutasSuroccidente
	 */
	private RutasSuroccidente() {
		marcaDAO= new MarcaDAO();
		marcas= new ArrayList<Marca>();
		// TODO Auto-generated constructor stub
	}

        
        /**
         * metofo que permite obterner el objeto para guardar una marca
         * @return el objeto para obtener un marca
         */
        public MarcaDAO getMarcaDAO() {
            return marcaDAO;
        }

        
        /**
         * metodo que establece el objet para guardar marcas
         * @param marcaDAO el objeto a establecer
         */
        public void setMarcaDAO(MarcaDAO marcaDAO) {
            this.marcaDAO = marcaDAO;
        }

        
        /**
         * metodo que permite obtener la lista de marcas
         * @return el objeto de la lista de marcas
         */
        public ArrayList<Marca> getMarcas() {
            return marcas;
        }

        
        /**
         * metodo que permite establecer la lista de marcas
         * @param marcas la lista de marcas a establecer
         */
        public void setMarcas(ArrayList<Marca> marcas) {
            this.marcas = marcas;
        }
	//-------------------------------------------------------------------------------------------
	//REQUERIMIENTOS
	//-------------------------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------------------------
	//GESTIONAR MARCA
	//-------------------------------------------------------------------------------------------
	
	
	/**
	 * metodo que permite buscar una marca por nombre<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas
	 * <b>post:</b> se  ha buscado y retornado la marca con el nombre pasado como parametro
	 * @param nNombre el nombre con el que se busca la marca nNombre !=null
	 * @return la marca con en nombre si no se encuentra una marca con el nombre como parametro null
	 */
	public Marca buscarMarca(String nNombre){
            Marca retorno= null;
            for(int i=0; i<marcas.size();i++){
                String miNombre= marcas.get(i).getNombre();
                if(miNombre.equals(nNombre)){
                    retorno= marcas.get(i);
                }
            }
            return retorno;
	}
	
	
	/**
	 * metodo que permite eliminar una marca<br>
	 * <b>pre:</b> se ha inicializado la lista de marcas y el atributo marcasDAO<br>
	 * <b>post:</b> se ha eliminado una marca con el nombre pasado como parametro
	 * @param nNombre el nombre por el cual se elimina la marca
	 */
	public void eliminarMarca(String nNombre){
            Marca buscada= buscarMarca(nNombre);
            marcas.remove(buscada);
            marcaDAO.eliminar(buscada);
	}
	
	
	/**
	 * metodo que permite modificar una marca<br>
	 * <b>pre:</b> se ha inicializado la lista de marcas y el atributo marcasDAO<br>
	 * <b>post:</b> se ha modificado la marca con el nombre pasado como paramtro
	 * @param nNombre el nuevo nombre de la marca
         * @param vNombre el viejo nombre de la marca
	 */
	public void modificarMarca(String nNombre, String vNombre){
            Marca buscada= buscarMarca(vNombre);
            buscada.setNombre(nNombre);
            marcaDAO.actualizar(buscada,vNombre);
	}
	
	
	/**
	 * metodo que permite agregar una marca
	 * <b>pre:</b> se ha inicializado la lista de marcas y el atributo marcasDAO<br>
	 * <b>post:</b> se ha agregao una marca con el nombre pasado como parametro
	 * @param nNombre el nombre de la marca
	 */
	public void agregarMarca(String nNombre){
            Marca buscada= buscarMarca(nNombre);
            if(buscada==null){
                Marca agregar= new Marca(nNombre);
                marcas.add(agregar);
                marcaDAO.agregar(agregar);
            }
	}
	
	
	//-------------------------------------------------------------------------------------------
	//GESTIONAR LINEA
	//-------------------------------------------------------------------------------------------
	
	
	/**
	 * metodo que permite buscar una linea por nombre<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas y lineas<br>
	 * <b>post:</b> se  ha buscado y retornado la linea con el nombre pasado como parametro
	 * @param nNombre el nombre con el que se busca la linea nNombre !=null
	 * @return la linea con en nombre si no se encuentra una linea con el nombre como parametro null
	 */
	public Linea buscarLinea(String nNombre){
            Linea retorno=null;
		for(int i=0; i<marcas.size();i++){
                    ArrayList<Linea> lineas = marcas.get(i).getLineas();
                    for(int j=0; j<lineas.size(); j++){
                        Linea linea= lineas.get(j);
                        if(linea.getNombre().equals(nNombre)){
                            retorno=linea;
                        }
                    }
                }
            return retorno;
	}
	
	
	/**
	 * metodo que permite eliminar una linea<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas
	 * <b>post:</b> se ha eliminado una marca con el nombre pasado como parametro del programa y la base de datos
	 * @param nNombre el nombre por el cual se elimina la linea
	 */
	public void eliminarLinea(String nNombre){
            Marca marcaE=null;
            Linea buscada = buscarLinea(nNombre);
            for(int i=0;i<marcas.size();i++){
                Marca marca= marcas.get(i);
                for(int j=0;j<marca.getLineas().size();j++){
                    Linea linea= marca.getLineas().get(j);
                    if(linea.getNombre().equals(nNombre)){
                        marcaE=marca;
                    }
                }
            }
            if(marcaE!=null){
                marcaE.getLineas().remove(buscada);
                marcaE.getLineaDAO().eliminar(marcaE, buscada);
            }
	}
	
	
	/**
	 * metodo que permite modificar una linea<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas
	 * <b>post:</b> se ha modificado la linea con el nombre pasado como parametro
	 * @param nNombre el nuevo nombre de la linea
         * @param vNombre el viejo nombre de la linea
	 */
	public void modificarLinea(String nNombre, String vNombre){
            Marca marcaE=null;
            Linea buscada = buscarLinea(vNombre);
            for(int i=0;i<marcas.size();i++){
                Marca marca= marcas.get(i);
                for(int j=0;j<marca.getLineas().size();j++){
                    Linea linea= marca.getLineas().get(j);
                    if(linea.getNombre().equals(vNombre)){
                        marcaE=marca;
                    }
                }
            }
            if(marcaE!=null){
                buscada.setNombre(nNombre);
                marcaE.getLineaDAO().actualizar(marcaE, buscada, vNombre);
            }
	}
	
	
	/**
	 * metodo que permite agregar una linea
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas
	 * <b>post:</b> se ha agregao una linea con el nombre pasado como parametro
	 * @param nNombreLinea  el nombre de la linea
         * @param nNombreMarca el nombre de la marca
	 */
	public void agregarLinea(String nNombreMarca, String nNombreLinea){
            Marca buscada= buscarMarca(nNombreMarca);
            Linea nueva= new Linea(nNombreLinea);
            buscada.getLineas().add(nueva);
            buscada.getLineaDAO().agregar(buscada, nueva);
	}
	
	
	//------------------------------------------------------------------------------------------
	//GESRIONAR VEHICULO
	//------------------------------------------------------------------------------------------
	
	
	/**
	 * metodo que permite buscar un vehiculo por placa<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas y vehiculos<br>
	 * <b>post:</b> se  ha buscado y retornado el vehiculo con la placa pasada como parametro
	 * @param nPlaca la placa con la que se busca el vehiculo nPlaca !=null
	 * @return el vehiculo con la placa pasada como parametro de lo contrario null
	 */
	public Vehiculo buscarVehiculo(String nPlaca){
            Vehiculo retorno=null;
            for(int i=0;i<marcas.size();i++){
                Marca miMarca = marcas.get(i);
                ArrayList<Linea> misLineas = miMarca.getLineas();
                for(int j=0;j<misLineas.size();j++){
                    Linea miLinea = misLineas.get(j);
                    ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                    for(int k=0;k<misVehiculos.size();k++){
                        Vehiculo miVehiculo = misVehiculos.get(k);
                        if(miVehiculo.getPlaca().equals(nPlaca)){
                            retorno= miVehiculo;
                        }
                    }
                }
            }
            return retorno;
	}
	
	
	/**
	 * metodo que permite eliminar una linea<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas y vehiculos<br>
	 * <b>post:</b> se ha eliminado un vehiculo con la placa pasada como parametro del programa y la base de datos
	 * @param nPlaca la placa con la cual se elimina el vehiculo
	 */
	public void eliminarVehiculo(String nPlaca){
            for(int i=0;i<marcas.size();i++){
                Marca miMarca = marcas.get(i);
                ArrayList<Linea> misLineas = miMarca.getLineas();
                for(int j=0;j<misLineas.size();j++){
                    Linea miLinea = misLineas.get(j);
                    ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                    for(int k=0;k<misVehiculos.size();k++){
                        Vehiculo miVehiculo = misVehiculos.get(k);
                        if(miVehiculo.getPlaca().equals(nPlaca)){
                            misVehiculos.remove(miVehiculo);
                            miLinea.getVehiculoDAO().eliminar(miMarca, miLinea, miVehiculo);
                        }
                    }
                }
            }
	}
	
	
	/**
	 * metodo que permite modificar un vehiculo
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas y vehiculos<br>
	 * <b>post:</b> se ha modificado los datos del vehiculo por los pasados como parametro
	 * @param nModelo el modelo del vehiculo nModelo>0
	 * @param nNumeroPasajeros el numero de pasajeros del vehiculos nNumeroPasajeros>0 
	 * @param nFotografia la fotografia del vehiculo nFotografia !=null
	 */
	public void modificarVehiculo(int nModelo, int nNumeroPasajeros, BufferedImage nFotografia, String nPlaca){
            for(int i=0;i<marcas.size();i++){
                Marca miMarca = marcas.get(i);
                ArrayList<Linea> misLineas = miMarca.getLineas();
                for(int j=0;j<misLineas.size();j++){
                    Linea miLinea = misLineas.get(j);
                    ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                    for(int k=0;k<misVehiculos.size();k++){
                        Vehiculo miVehiculo = misVehiculos.get(k);
                        if(miVehiculo.getPlaca().equals(nPlaca)){
                            miVehiculo.setFotografia(nFotografia);
                            miVehiculo.setModelo(nModelo);
                            miVehiculo.setNumeroPasajeros(nNumeroPasajeros);
                            miLinea.getVehiculoDAO().actualizar(miMarca, miLinea, miVehiculo);
                        }
                    }
                }
            }
	}
	
	
	/**
	 * metodo que permite agregar un vehiculo
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas y vehiculos<br>
	 * <b>post:</b> se ha agregado un vehiculo con los datos pasados como parametros<br>
	 * @param nMarca la marca del vehiculo nMarca !=""
	 * @param nLinea la linea del vehucilo nLinea!=""
	 * @param nModelo el modelo del vehiculo nModelo>0
	 * @param nPlaca la placa del vehiculo nPlaca!=""
	 * @param nNumeroPasajeros el numero de pasajeros del vehiculos nNumeroPasajeros>0 
	 * @param nFotografia la fotografia del vehiculo nFotografia !=null
	 */
	public void agregarVehiculo(String nMarca, String nLinea, int nModelo, String nPlaca, int nNumeroPasajeros, BufferedImage nFotografia){
            Linea linea= buscarLinea(nLinea);
            Marca marca= buscarMarca(nMarca);
            Vehiculo v= new Vehiculo(nModelo, nPlaca, nNumeroPasajeros, nFotografia);
            linea.getVehiculos().add(v);
            linea.getVehiculoDAO().agregar(marca, linea, v);
	}
	
	
	//------------------------------------------------------------------------------------------
	//GESTIONAR PROPIETARIO
	//------------------------------------------------------------------------------------------
	
	
	/**
	 * metodo que permite buscar un propietario por identificacion<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos<br>
	 * <b>post:</b> se  ha buscado y retornado el propietario con la identificacion pasada como paramtro
	 * @param nIdentificacion la identificacion con la que se busca el propietario nIdentificacion!=null
         * @param nPlaca la placa del vehiculo
	 * @return el propietario la identificacion pasada como parametro de lo contrario null
	 */
	public Propietario buscarPropietario(int nIdentificacion){
            Propietario retorno=null;
            for(int i=0;i<marcas.size();i++){
                Marca miMarca = marcas.get(i);
                ArrayList<Linea> misLineas = miMarca.getLineas();
                for(int j=0;j<misLineas.size();j++){
                    Linea miLinea = misLineas.get(j);
                    ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                    for(int k=0;k<misVehiculos.size();k++){
                        Vehiculo miVehiculo = misVehiculos.get(k);
                        Propietario miPropietario = miVehiculo.getPropietario();
                        if(miPropietario.getIdentificacion()==nIdentificacion){
                            retorno= miPropietario;
                        }
                    }
                }
            }
            return retorno;
	}
	
	
	/**
	 * metodo que permite eliminar una propietario de un vehiculo<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos<br>
	 * <b>post:</b> se ha eliminado el propitario del vehiculo con la palca pasada como parametro del programa y la base de datos
	 * @param nPlaca la placa con el cual se elimina e vehiculo
         * @param nIdentificacion la identificacion con la que se busca el propietario nIdentificacion!=null
	 */
	public void eliminarPorpietarioVehiculo(int nIdentificacion){
            
	}
	
	
	/**
	 * metodo que permite modificar un prietario<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos<br>
	 * <b>post:</b> se ha modificado los datos del propuetario del vehiculo 
	 * @param nAplellidos los apellidos del propuetario nApellidos!=""
	 * @param nDireccion la direccion del propietario nDireccion!=""
	 * @param nIdentificacion la identificacion del propietario nIdentificacion>0
	 * @param nNombres los nombres del propietario nNombres!=""
	 * @param nTelefono el telefono del propietario telefono>0
	 */
	public void modificarPropietario(String nAplellidos, String nDireccion, int nIdentificacion, String nNombres, int nTelefono){
		
	}
	
	
	/**
	 * metodo que permite agregar un propietario a un vehiculo<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos<br>
	 * <b>post:</b> se ha agregado un propuetario a un vehiculo
	 * @param nAplellidos los apellidos del propuetario nApellidos!=""
	 * @param nDireccion la direccion del propietario nDireccion!=""
	 * @param nIdentificacion la identificacion del propietario nIdentificacion>0
	 * @param nNombres los nombres del propietario nNombres!=""
	 * @param nTelefono el telefono del propietario telefono>0
	 * @param nPlaca la placa del vehiculo al cual se va a agregar el propuetario
	 */
	public void agregarPropietario(String nAplellidos, String nDireccion, int nIdentificacion, String nNombres, int nTelefono, String nPlaca){
		
	}
	
	
	//------------------------------------------------------------------------------------------
	//GESTIONAR CLIENTE
	//------------------------------------------------------------------------------------------
	
	
	/**
	 * metodo que permite buscar un cliente por identificacion<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos, tiquetes<br>
	 * <b>post:</b> se  ha buscado y retornado el cliente con la identificacion pasada como paramtro
	 * @param nIdentificacion la identificacion con la que se busca al cliente nIdentificacion!=null
	 * @return el cliente con la identificacion pasada como parametro de lo contrario null
	 */
	public Cliente buscarCliente(int nIdentificacion){
		
	}
	
        
	/**
	 * metodo que permite eliminar una cliente del programa<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos, tiquetes<br>
	 * <b>post:</b> se ha eliminado el cliente con la identificacion pasada como parametro del programa y la base de datos
	 * @param nIdentificacion la identificacion por la caual se elimina al cliente
	 */
	public void eliminarCliente(int nIdentificacion){
		
	}
	
	
	/**
	 * metodo que permite modificar un cliente<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos, tiquetes<br>
	 * <b>post</b> se ha modificado el cliente por los datos pasados como parametros
	 * @param nNombres los nombres del cliente nNombres!=""
	 * @param nApellidos los apellidos del cliente nApellidos!=""
	 * @param nIdentificacion la identificacion del cliente!=""
	 */
	public void modificarCliente(String nNombres, String nApellidos, int nIdentificacion){
		
	}
	
	
	/**
	 * metodo que permite agregar un cliente a un tiquete<br>
	 * <b>pre:</b> se ha inicializado la lista de maracas, lineas, vehiculos, tiquetes<br>
	 * <b>post:</b> se ha agreagado un cliente a un tiquete
	 * @param nNombres los nombres del cliente nNombres!=""
	 * @param nApellidos los apellidos del cliente nApellidos!=""
	 * @param nIdentificacion la identificacion del cliente!=""
	 * @param nHoraVenta la hora de la venta del tiquete nHoraVenta!=null
	 * @param nValorTiquete el valor por la venta del tiquete nValorTiquete>0 
	 */
	public void agregarCliente(String nNombres, String nApellidos, int nIdentificacion, Date nHoraVenta, double nValorTiquete){
		
	}
}