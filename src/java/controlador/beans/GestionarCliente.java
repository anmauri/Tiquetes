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
public class GestionarCliente extends Controller{

    
    private Vehiculo vehiculo;
    private ArrayList<Vehiculo> listaVehiculos;
    /**
     * Creates a new instance of GestionarCliente
     */
    public GestionarCliente() {
    }
    
}
