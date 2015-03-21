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
    /**
     * crea una nueva instancia de GestionarLinea
     */
    public GestionarLinea() {
        linea = new Linea("");
        listaLineas= new ArrayList<Linea>();
    }
    
}