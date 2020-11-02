package co.GetFood.restaurante.domain.service;

import java.util.List;

import co.GetFood.restaurante.domain.entity.Restaurante;
import co.GetFood.restaurante.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.restaurante.presentation.rest.exceptions.RestauranteDomainException;



public interface IRestauranteService {
	public List<Restaurante> findAll();

	//public List<Restaurante> findById();

}
