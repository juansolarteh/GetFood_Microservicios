package co.GetFood.restaurante.domain.service;

import java.util.List;


import co.GetFood.restaurante.domain.entity.Restaurante;
import co.GetFood.restaurante.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.restaurante.presentation.rest.exceptions.RestauranteDomainException;



public interface IRestauranteService {
	public List<Restaurante> findAll();

	public Restaurante findById(Long id)throws ResourceNotFoundException;
	
	public Restaurante update(Restaurante restaurante, Long id) throws ResourceNotFoundException;

}
