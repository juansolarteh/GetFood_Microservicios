package co.GetFood.Pedido.access.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.GetFood.Pedido.domain.entity.Pedido;


/**
 * Interfaces DAO de productos
 *@author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public interface IPedidoDao extends CrudRepository<Pedido, Long> {
	
	/**
	 * Metodo de la interfaz IPlatoDao que permite retornar
	 * todso los platos que hacen parte de un restaurante en especifico
	 * @param id. identificador del restaurantes
	 * @return platos del restaurantes
	 */
	@Query("select c from Pedido c where c.id_restaurante = ?1")
	List<Pedido> findByIdRest(Long idRest);

}