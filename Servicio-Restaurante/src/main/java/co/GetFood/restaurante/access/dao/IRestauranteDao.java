package co.GetFood.restaurante.access.dao;


import org.springframework.data.repository.CrudRepository;

import co.GetFood.restaurante.domain.entity.Restaurante;


public interface IRestauranteDao extends CrudRepository<Restaurante, Long> {

}