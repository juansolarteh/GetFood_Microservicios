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

/**
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 * Implementación de la Interfaz IRestauranteService
 *
 */
@Service
public class RestauranteImplService implements IRestauranteService {
	/**
	 * Inyección de Restaurante Dao
	 */
	@Autowired
	private IRestauranteDao restauranteDao;

	/**
	 * Servicio para buscar todos los restaurantes
	 * 
	 * 
	 * @return Listado de restaurantes
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Restaurante> findAll() {
		return (List<Restaurante>) restauranteDao.findAll();
	}
	
	/**
	 * Servicio para buscar restaurante por ID
	 * 
	 * @param id del restaurante
	 * @return Restaurante
	 */
	@Override
	public Restaurante findById(Long id) throws RestauranteDomainException, ResourceNotFoundException {
		Restaurante rest = restauranteDao.findById(id).orElse(null);
		List<RestauranteError> errors = validateDomain(rest);
		if(!errors.isEmpty()) {
			throw new RestauranteDomainException(errors);
		}
		return rest;
	}
	/**
	 * Servicio para actualizar el estado del restaurante
	 * 
	 * @param Objeto Restaurante
	 * @param Id Restaurante
	 * @return Restaurante modificado
	 */
	@Override
	@Transactional
	public Restaurante update(Restaurante restaurante, Long id) throws RestauranteDomainException, ResourceNotFoundException {
		
		Restaurante rest = this.findById(id);
		if (rest == null) {
			throw new ResourceNotFoundException();
		}

		rest.setRestabierto(restaurante.isRestabierto());

		return restauranteDao.save(rest);
		
	}
	
	/**
	 * Valida las reglas del dominio para las operaciones requeridas.
	 * @param restaurante que se desea validar 
	 * @return lista de errores al valdidar
	 */
	private List<RestauranteError> validateDomain(Restaurante rest) {
		List<RestauranteError> errors = new ArrayList<>();
		
		if (rest == null) {
			errors.add(new RestauranteError(EnumErrorCodes.NOT_FOUND, "restnit", "No existe ID"));
		}else {
			if (rest.getRestnit()<=0) {
				errors.add(new RestauranteError(EnumErrorCodes.INVALID_NUMBER, "restnit",
						"El Id debe ser mayor a 0"));
			}
		}
		return errors;
	}
	
	
}
