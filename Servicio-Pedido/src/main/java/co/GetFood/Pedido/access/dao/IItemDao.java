package co.GetFood.Pedido.access.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;


/**
 * Interfaces DAO de items
 *@author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public interface IItemDao extends CrudRepository<Item, Long> {
	/**
	 * Metodo de la interfaz IPlatoDao que permite retornar
	 * todso los platos que hacen parte de un restaurante en especifico
	 * @param id. identificador del restaurantes
	 * @return platos del restaurantes
	 */
	@Query("select c from item c where c.id_pedido = ?1")
	List<Item> findByIdPedido(Long idPedido);
}