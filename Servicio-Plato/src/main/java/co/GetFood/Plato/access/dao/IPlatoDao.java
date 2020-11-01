package co.GetFood.Plato.access.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.GetFood.Plato.domain.entity.Plato;


/**
 * Interfaces DAO de productos
 * @author wpantoja, ahurtado
 *
 */
public interface IPlatoDao extends CrudRepository<Plato, Long> {
	
	@Query("select c from Plato c where c.id_rest = ?1")
	List<Plato> findByIdRest(Long id);

}