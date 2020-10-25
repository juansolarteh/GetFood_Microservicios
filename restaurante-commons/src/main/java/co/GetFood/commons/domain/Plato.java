/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.GetFood.commons.domain;

/**
 *
 * @author juan-
 */
public class Plato {
    private int atrPrecio;
    private String atrDescripcion;
    private String atrNombre;
    
    public Plato(String prmNombre,int prmPrecio,String prmDescripcion) {
        this.atrNombre=prmNombre;
        this.atrDescripcion=prmDescripcion;
        this.atrPrecio=prmPrecio;
    }
    
    public Plato(){}

    public int getAtrPrecio() {
        return atrPrecio;
    }

    public void setAtrPrecio(int atrPrecio) {
        this.atrPrecio = atrPrecio;
    }

    public String getAtrDescripcion() {
        return atrDescripcion;
    }

    public void setAtrDescripcion(String atrDescripcion) {
        this.atrDescripcion = atrDescripcion;
    }

    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }
    
    public String toString(){
        return atrNombre +" " + atrDescripcion+" $" + Integer.toString(atrPrecio);
    }
    
}
