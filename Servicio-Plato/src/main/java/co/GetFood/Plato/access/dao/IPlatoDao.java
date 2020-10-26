package co.GetFood.Plato.access.dao;


import org.springframework.data.repository.CrudRepository;

import co.GetFood.Plato.domain.entity.Plato;


/**
 * Interfaces DAO de productos
 * @author wpantoja, ahurtado
 *
 */
public interface IPlatoDao extends CrudRepository<Plato, Long> {

}