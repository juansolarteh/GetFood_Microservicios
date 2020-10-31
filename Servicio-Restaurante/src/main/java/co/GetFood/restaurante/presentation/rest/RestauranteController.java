package co.GetFood.restaurante.presentation.rest;

import java.util.List;

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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("restaurante")
public class RestauranteController {
	@Autowired
	private IRestauranteService restauranteService;

	/**
	 * Listar todos
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Restaurante> findAll() {
		return (List<Restaurante>) restauranteService.findAll();
	}
}