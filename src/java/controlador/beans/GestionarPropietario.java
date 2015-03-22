/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Propietario;
import modelo.mundo.Vehiculo;
import java.util.ArrayList;
import modelo.mundo.Linea;
import modelo.mundo.Marca;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarPropietario extends Controller{

    
    private Propietario propietario;
    private Vehiculo vehiculo;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Propietario> listaPropietarios;
    /**
     * Creates a new instance of GestionarPropietario
     */
    public GestionarPropietario() {
        propietario=new Propietario(0, "", "", "", 0);
        vehiculo= new Vehiculo(0, "", 0, null);
    }
    
    public void agregar(){
        super.darInstanciaMundo().agregarPropietario(propietario.getApellidos(), propietario.getDireccion(), propietario.getIdentificacion(), propietario.getNombres(), propietario.getTelefono(), vehiculo.getPlaca());
        restablecerLista();
    }
    public void eliminar(){
        mundo= super.darInstanciaMundo();
        mundo.eliminarPorpietarioVehiculo(propietario.getIdentificacion());
        restablecerLista();
    }
    public void modificar(){
        mundo= super.darInstanciaMundo();
        mundo.modificarPropietario(propietario.getApellidos(), propietario.getDireccion(), propietario.getIdentificacion(), propietario.getNombres(), propietario.getTelefono());
    }
    public void buscar(){
        Propietario p= super.darInstanciaMundo().buscarPropietario(propietario.getIdentificacion());
        if(p!=null){
            listaPropietarios.add(p);
        }
        else{
            listaPropietarios= new ArrayList<Propietario>();
        }
    }
    public void restablecerLista(){
        mundo=super.darInstanciaMundo();
        ArrayList<Marca> misMarcas = mundo.getMarcas();
        for(int i=0;i<misMarcas.size();i++){
            Marca miMarca=misMarcas.get(i);
            ArrayList<Linea> misLineas= miMarca.getLineas();
            for(int j=0;j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                for(int k=0;k<misVehiculos.size();k++){
                    Vehiculo miVehiculo = misVehiculos.get(k);
                    Propietario miPropietario = miVehiculo.getPropietario();
                    if(miPropietario!=null){
                        listaPropietarios.add(miPropietario);
                    }
                }
            }
        }
    }
    public void redireccionarVistaModificar(Propietario nPropietario){
        propietario= nPropietario;
        super.redireccionarVista("");
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }
}