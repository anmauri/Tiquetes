/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.RutasSuroccidente;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class GestionarLinea extends Controller{

    
    /**
     * objeto para encapsular los datos de la linea
     */
    private Linea linea;
    private static ArrayList<Linea> listaLineas;
    private String viejoNombre;
    private ArrayList<Marca> marcas;
    private Marca marcaSeleccionada;
    /**
     * crea una nueva instancia de GestionarLinea
     */
    public GestionarLinea() {
        linea = new Linea("");
        listaLineas= new ArrayList<Linea>();
        marcas= super.darInstanciaMundo().getMarcas();
        marcaSeleccionada = new Marca("");
    }
    
    public void agregar(){
        super.darInstanciaMundo().agregarLinea(marcaSeleccionada.getNombre(), linea.getNombre());
        restablecerLista();
    }
    public void modificar(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        mundo.modificarLinea(linea.getNombre(), viejoNombre);
    }
    public void eliminar(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        mundo.eliminarLinea(linea.getNombre());
        restablecerLista();
    }
    public void buscar(){
        Linea l= super.darInstanciaMundo().buscarLinea(linea.getNombre());
        if(l!=null){
            listaLineas.add(l);
        }
        else{
            listaLineas= new ArrayList<Linea>();
        }
    }
    public void restablecerLista(){
        RutasSuroccidente mundo= super.darInstanciaMundo();
        for(int i=0;i<mundo.getMarcas().size();i++){
            for(int j=0;j<mundo.getMarcas().get(i).getLineas().size();j++){
                listaLineas.add(mundo.getMarcas().get(i).getLineas().get(j));
            }
        }
    }
    public void redireccionarVistaModificar(Linea lineaSeleccionada){
        viejoNombre= lineaSeleccionada.getNombre();
        super.redireccionarVista("");
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public static ArrayList<Linea> getListaLineas() {
        return listaLineas;
    }

    public static void setListaLineas(ArrayList<Linea> listaLineas) {
        GestionarLinea.listaLineas = listaLineas;
    }

    public String getViejoNombre() {
        return viejoNombre;
    }

    public void setViejoNombre(String viejoNombre) {
        this.viejoNombre = viejoNombre;
    }

    public ArrayList<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(ArrayList<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Marca marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }
    
    
}