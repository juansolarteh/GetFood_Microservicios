package co.GetFood.commons.domain;

import java.util.ArrayList;
/**
 * Cliente de la agencia de viajes
 *
 * @author Libardo, Julio
 */
public class Restaurante {

    private String atrNombre;
    private int atrId;
    private String atrDirecccion;
    private int atrTelefono;
    private boolean atrAbierto;
    private ArrayList<Plato> atrMenu;
  
    public Restaurante(int prmId, String prmDireccion, String prmNombre, int prmTelefono, boolean prmAbierto) {
        this.atrId = prmId;
        this.atrDirecccion = prmDireccion;
        this.atrNombre = prmNombre;
        this.atrMenu= new ArrayList<Plato>();
        this.atrTelefono = prmTelefono;
        this.atrAbierto = prmAbierto;
    }
    
    public Restaurante() {

    }

    public ArrayList<Plato> getAtrMenu() {
        return atrMenu;
    }

    public void setAtrMenu(ArrayList<Plato> atrMenu) {
        this.atrMenu = atrMenu;
    }

    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }

    public int getAtrId() {
        return atrId;
    }

    public void setAtrNit(int atrId) {
        this.atrId = atrId;
    }

    public String getAtrDirecccion() {
        return atrDirecccion;
    }

    public int getAtrTelefono() {
        return atrTelefono;
    }
    
    public void setAtrDirecccion(String atrDirecccion) {
        this.atrDirecccion = atrDirecccion;
    }

    public void setAtrTelefono(int prmTelefono) {
        this.atrTelefono = prmTelefono;
    }
    
    public boolean getAtrAbierto() {
        return atrAbierto;
    }
    
    public void setAtrAbierto(boolean prmAbierto) {
        this.atrAbierto = prmAbierto;
    }
   
}
