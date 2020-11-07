package co.GetFood.restaurante.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.GetFood.restaurante.access.dao.IRestauranteDao;
import co.GetFood.restaurante.domain.entity.Restaurante;
import co.GetFood.restaurante.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.restaurante.presentation.rest.exceptions.RestauranteDomainException;
import co.GetFood.restaurante.presentation.rest.exceptions.RestauranteError;


@Service
public class RestauranteImplService implements IRestauranteService {
	/**
	 * Inyección de producto Dao
	 */
	@Autowired
	private IRestauranteDao restauranteDao;

	/**
	 * Servicio para buscar todos los productos
	 * 
	 * @return Listado de productos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Restaurante> findAll() {
		return (List<Restaurante>) restauranteDao.findAll();
	}

	@Override
	public Restaurante findById(Long id) throws ResourceNotFoundException {
		Restaurante rest = restauranteDao.findById(id).orElse(null);
		if(rest==null) {
			throw new ResourceNotFoundException();
		}
			return rest;
	}
	@Override
	@Transactional
	public Restaurante update(Restaurante restaurante, Long id) throws ResourceNotFoundException {
		
		Restaurante rest = this.findById(id);
		if (rest == null) {
			throw new ResourceNotFoundException();
		}
		/*
		List<PlatoError> errors = validateDomain(plato);

		if (!errors.isEmpty()) {
			throw new PlatoDomainException(errors);
		}*/

		rest.setRestabierto(restaurante.isRestabierto());

		return restauranteDao.save(rest);
		
	}

	
}
