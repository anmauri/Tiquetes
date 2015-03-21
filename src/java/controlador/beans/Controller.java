/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.mundo.RutasSuroccidente;

/**
 *
 * @author MiPc
 */
@ManagedBean
@RequestScoped
public class Controller {

    
    /**
     * objeto que permite acceder al mundo del problema
     */
    protected RutasSuroccidente mundo;
    
    
    /**
     * crea una nueva instancia de Controller
     */
    public Controller() {
    }
    
    
    /**
     * metodo que permite obtener una instancian del mudo si no la hay la crea
     * @return la instancia del mundo
     */
    public RutasSuroccidente darInstanciaMundo(){
        if(mundo==null){
            return new RutasSuroccidente();
        }
        else{
            return mundo;
        }
    }
    
    
    /**
     * metodo que oermite redireccionar las vistas
     * @param nombreVista el nombre del archivo con la vista
     */
    public void redireccionarVista(String nombreVista){
        try{
        FacesContext contex= FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect(nombreVista);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * metodo que retorna la instancia del mundo
     * @return la instancia del mundo
     */
    public RutasSuroccidente getMundo() {
        return mundo;
    }

    
    /**
     * metodo que permite establecer una instancia del mundo
     * @param mundo la instancia del mundo a cambiar
     */
    public void setMundo(RutasSuroccidente mundo) {
        this.mundo = mundo;
    }
}