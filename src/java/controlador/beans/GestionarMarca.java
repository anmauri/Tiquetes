/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Marca;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarMarca extends Controller{

    
    /**
     * objeto para encapsular datos de la marca
     */
    private Marca marca;
    
    
    /**
     * lista para mostrar la informaciond de la marca
     */
    private static ArrayList<Marca> listaMarcas;
    
    
    /**
     * crea una nueva instancia de GestionarMarca
     */
    public GestionarMarca() {
        marca= new Marca("");
        listaMarcas= new ArrayList<Marca>();
    }
    
    
    public void agregar(){
        
    }
    public void eliminar(){
        
    }
    public void modificar(){
        
    }
    public void buscar(){
        
    }
    public void restablecerBusqueda(){
        listaMarcas= super.darInstanciaControlador();
    }
    public void redireccionarVistaModificar(){
        super.redireccionarVista("");
    }
    /**
     * metodo que permite obtener la instaniciandde la marca
     * @return la instancia de la marca 
     */
    public Marca getMarca() {
        return marca;
    }

    
    /**
     * meotodo que permite establecer una marca
     * @param marca la marca que se va a establecer
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    /**
     * metodo que permite btener la lista de marcas
     * @return la lista de mascas
     */
    public static ArrayList<Marca> getListaMarcas() {
        return listaMarcas;
    }

    
    /**
     * metodo que permite establecer la lista de marcas
     * @param listaMarcas la lista de marcas a establecer
     */
    public static void setListaMarcas(ArrayList<Marca> listaMarcas) {
        GestionarMarca.listaMarcas = listaMarcas;
    }
}