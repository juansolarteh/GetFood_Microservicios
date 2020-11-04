package co.GetFood.Plato.access.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.GetFood.Plato.domain.entity.Plato;


/**
 * Interfaces DAO de productos
 *@author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Tulande
 *
 */
public interface IPlatoDao extends CrudRepository<Plato, Long> {
	
	/**
	 * Metodo de la interfaz IPlatoDao que permite retornar
	 * todso los platos que hacen parte de un restaurante en especifico
	 * @param id. identificador del restaurantes
	 * @return platos del restaurantes
	 */
	@Query("select c from Plato c where c.id_rest = ?1")
	List<Plato> findByIdRest(Long id);

}