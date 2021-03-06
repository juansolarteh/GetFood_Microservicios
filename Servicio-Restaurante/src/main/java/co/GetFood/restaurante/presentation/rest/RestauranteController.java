package co.GetFood.restaurante.presentation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.GetFood.restaurante.domain.entity.Restaurante;
import co.GetFood.restaurante.domain.service.IRestauranteService;
import co.GetFood.restaurante.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.restaurante.presentation.rest.exceptions.RestauranteDomainException;

/**
 * Servicio web de restaurantes
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("restaurante")
public class RestauranteController {
	@Autowired
	private IRestauranteService restauranteService;

	/**
	 * Listar todos los restaurantes
	 * 
	 * @return listado de restaurantes en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Restaurante> findAll() {
		return (List<Restaurante>) restauranteService.findAll();
	}
	
	/**
	 * Obtener restaurante por ID
	 * @param id del restaurante
	 * @return Restaurante encontrado por el Id 
	 * @throws RestauranteDomainException
	 * 
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Restaurante findById(@PathVariable Long id) throws RestauranteDomainException, ResourceNotFoundException{
		return restauranteService.findById(id);
	}
	
	/**
	 * Actualizar estado de restaurante 
	 * @param rest:Restaurante
	 * @param restnit: Id del restaurante
	 * @return Restaurante actualizado
	 * @throws RestauranteDomainException
	 * 
	 */
	@RequestMapping(value = "{restnit}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Restaurante update(@RequestBody Restaurante rest,@PathVariable Long restnit) throws RestauranteDomainException, ResourceNotFoundException {
		return restauranteService.update(rest,restnit);
	}
	
}