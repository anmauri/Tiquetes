/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.RutasSuroccidente;
import modelo.mundo.Vehiculo;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarVehiculo extends Controller{

    private Vehiculo vehiculo;
    private Linea linea;
    private Marca marca;
    private static ArrayList<Vehiculo> listaVehiculo;
    private ArrayList<Linea> listaLineas;
    private ArrayList<Marca> listaMarcas;
    /**
     * Creates a new instance of GestionarVehiculo
     */
    public GestionarVehiculo() {
        vehiculo= new Vehiculo(0, "", 0, null);
        listaVehiculo= new ArrayList<Vehiculo>();
    }
    public void agregar(){
        super.darInstanciaMundo().agregarVehiculo(marca.getNombre(), linea.getNombre(), vehiculo.getModelo(), vehiculo.getPlaca(), vehiculo.getModelo(), vehiculo.getFotografia());
        restablecerLista();
    }
    public void eliminar(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        mundo.eliminarVehiculo(vehiculo.getPlaca());
        restablecerLista();
    }
    public void modificar(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        mundo.modificarVehiculo(vehiculo.getModelo(), vehiculo.getNumeroPasajeros(), vehiculo.getFotografia());
    }
    public void buscar(){
        Vehiculo v= super.darInstanciaMundo().buscarVehiculo(vehiculo.getPlaca());
        if(v!=null){
            listaVehiculo.add(v);
        }
        else{
            listaVehiculo= new ArrayList<Vehiculo>();
        }
    }
    public void restablecerLista(){
        RutasSuroccidente mundo=super.darInstanciaMundo();
        ArrayList<Marca> misMarcas = mundo.getMarcas();
        for(int i=0;i<misMarcas.size();i++){
            Marca miMarca=misMarcas.get(i);
            ArrayList<Linea> misLineas= miMarca.getLineas();
            for(int j=0;j<misLineas.size();j++){
                Linea miLinea = misLineas.get(j);
                ArrayList<Vehiculo> misVehiculos = miLinea.getVehiculos();
                for(int k=0;k<misVehiculos.size();k++){
                    Vehiculo miVehiculo = misVehiculos.get(k);
                    listaVehiculo.add(miVehiculo);
                }
            }
        }
    }
    public void redireccionarVistaModificar(Vehiculo nVehiculo){
        vehiculo= nVehiculo;
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

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ArrayList<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(ArrayList<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public ArrayList<Marca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(ArrayList<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }
}