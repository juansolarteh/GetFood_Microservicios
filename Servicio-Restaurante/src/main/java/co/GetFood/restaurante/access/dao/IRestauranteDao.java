package co.GetFood.restaurante.access.dao;


import org.springframework.data.repository.CrudRepository;

import co.GetFood.restaurante.domain.entity.Restaurante;

/**
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *	Interfaz DAO de Restuarante que extiende CrudRepository
 */

public interface IRestauranteDao extends CrudRepository<Restaurante, Long> {

}