package co.GetFood.commons.access;

import co.GetFood.commons.domain.Restaurante;
import co.GetFood.commons.infra.Utilities;
import co.GetFood.commons.domain.Plato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Clientes en MySWL
 *
 * @author Libardo, Julio
 */
public class RestauranteRepositoryImplMysql implements IRestauranteRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositoryImplMysql() {
    }
    /**
     * Busca en la bd un customer
     * @param id cedula
     * @return objeto customer, null si no lo encuentra
     */
    @Override
    public Plato addPlato(Plato plato) {
        try {
            this.connect();
            String sql = "INSERT INTO PLATOS(restid, pltNombre, pltPrecio, pltDescripcion) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);              
            pstmt.setInt(1, 101);
            pstmt.setString(2, plato.getAtrNombre());
            pstmt.setInt(3, plato.getAtrPrecio());
            pstmt.setString(4, plato.getAtrDescripcion());
            pstmt.executeUpdate();       
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return plato;
    }

    @Override
    public ArrayList<Plato> getMenu(int idRestaurantes) {
        ArrayList<Plato> menu = new ArrayList<Plato>();
        try{
            this.connect();
            String sql = "SELECT * from Platos where restid=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(idRestaurantes));
            ResultSet res = pstmt.executeQuery();
            while(res.next()) {      
                Plato plato = new Plato();
                plato.setAtrNombre(res.getString("pltNombre"));
                plato.setAtrDescripcion(res.getString("pltDescripcion"));
                plato.setAtrPrecio(Integer.parseInt(res.getString("pltPrecio")));
                menu.add(plato);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return menu;
    }
    
    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username");
            String pwd = Utilities.loadProperty("server.db.password");
            conn = DriverManager.getConnection(url, username, pwd);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

    @Override
    public ArrayList<Restaurante> getRestaurantes() {
        ArrayList<Restaurante> Restaurantes = new ArrayList<Restaurante>();
        try{
            this.connect();
            String sql = "SELECT * from restaurante";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while(res.next()) {      
                Restaurante RegistroRes = new Restaurante();
                RegistroRes.setAtrNit(Integer.parseInt(res.getString("restNit"))); 
                RegistroRes.setAtrNombre(res.getString("restNombre"));
                RegistroRes.setAtrDirecccion(res.getString("restDireccion"));
                RegistroRes.setAtrTelefono(Integer.parseInt(res.getString("restTelefono")));
                RegistroRes.setAtrAbierto(Boolean.parseBoolean(res.getString("restAbierto")));
                Restaurantes.add(RegistroRes);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return Restaurantes;
    }
}
