/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarVehiculo extends Controller{

    private Vehiculo vehiculo;
    private static ArrayList<Vehiculo> listaVehiculo;
    /**
     * Creates a new instance of GestionarVehiculo
     */
    public GestionarVehiculo() {
        vehiculo= new Vehiculo(0, "", 0, null);
        listaVehiculo= new ArrayList<Vehiculo>();
    }
    public void agregar(){
        
    }
    public void eliminar(){
        
    }
    public void modificar(){
        
    }
    public void buscar(){
        
    }
    public void restablecerLista(){
        
    }
    public void redireccionarVistaModificar(){
        super.redireccionarVista("");
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public static ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public static void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        GestionarVehiculo.listaVehiculo = listaVehiculo;
    }
    
}