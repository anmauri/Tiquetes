/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Marca;
import modelo.mundo.RutasSuroccidente;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarMarca extends Controller{

    private RutasSuroccidente mundo;
    
    /**
     * objeto para encapsular datos de la marca
     */
    private Marca marca;
    
    
    /**
     * lista para mostrar la informaciond de la marca
     */
    private static List<Marca> listaMarcas;
    
    
    /**
     * el viejo nombre de las marcas
     */
    private String viejoNombre;
    
    
    /**
     * crea una nueva instancia de GestionarMarca
     */
    public GestionarMarca() {
        marca= new Marca("");
        listaMarcas= new ArrayList<Marca>();
        mundo= super.darInstanciaMundo();
    }
    
    
    public void agregar(){
        mundo.agregarMarca(marca.getNombre());
        restablecerLista();
    }
    public void eliminar(Marca marca){
        mundo.eliminarMarca(marca.getNombre());
        restablecerLista();
    }
    public void modificar(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        mundo.modificarMarca(marca.getNombre(), viejoNombre);
    }
    public void buscar(){
        Marca m= super.darInstanciaMundo().buscarMarca(marca.getNombre());
        if(m!=null){
            listaMarcas.add(m);
        }
        else{
            listaMarcas= new ArrayList<Marca>();
        }
    }
    public void restablecerLista(){
        listaMarcas= mundo.getMarcas();
    }
    public void redireccionarVistaModificar(Marca marcaSeleccionada){
        viejoNombre= marcaSeleccionada.getNombre();
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
    public List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    
    /**
     * metodo que permite establecer la lista de marcas
     * @param listaMarcas la lista de marcas a establecer
     */
    public void setListaMarcas(List<Marca> listaMarcas) {
        GestionarMarca.listaMarcas = listaMarcas;
    }

    
    /**
     * metodo que permite obtener aceso al antigui nombre de una marca
     * @return el antigui nombre una marca
     */
    public String getViejoNombre() {
        return viejoNombre;
    }

    
    /**
     * metodoq que permite establecer el viejo nombre de una marca
     * @param viejoNombre parametro para establecer el viejo nombre de la marca
     */
    public void setViejoNombre(String viejoNombre) {
        this.viejoNombre = viejoNombre;
    }
}