package co.GetFood.commons.access;

import java.util.ArrayList;
import co.GetFood.commons.domain.Restaurante;
import co.GetFood.commons.domain.Plato;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
public interface IGetFoodRepository {
    /**
     * Busca un Customer por su ceduka
     * @param id cedula del cliente
     * @return  objeto de tipo Customer
     */
    public Plato addPlato(Plato Plato);
    
    public ArrayList<Plato> getMenu(int idRestaurantes);
    
    public ArrayList<Restaurante> getRestaurantes();
    
    public boolean EliminarPlato(int idPlato);
    
    public Plato ActualizarPlato(int idPlato, Plato platoActualizacion);
}
