package co.GetFood.Plato.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.GetFood.Plato.domain.entity.Plato;
import co.GetFood.Plato.domain.service.IPlatoService;
import co.GetFood.Plato.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.Plato.presentation.rest.exceptions.PlatoDomainException;

/**
 * Servicios web de platos
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("plato")
public class ProductController {
	@Autowired
	private IPlatoService platoService;

	/**
	 * Listar todos
	 * 
	 * @return listado de platos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Plato> findAll() {
		return (List<Plato>) platoService.findAll();
	}

	/**
	 * Listar un plato por id
	 * 
	 * @param id identificador
	 * @return Plato en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Plato findById(@PathVariable Long id) throws ResourceNotFoundException {
		return platoService.findById(id);
	}
	
	
	/**
	 * listar platos por restaurante.
	 * @param id_rest identificador del restaurante.
	 * @return Lista de platos de restaurante con id id_rest.
	 */
	@RequestMapping(value = "rest/{id_rest}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Plato> findByIdRest(@PathVariable Long id_rest)  {
		return  (List<Plato>) platoService.findByIdRest(id_rest);
	}


	/**
	 * Crear un plato
	 * 
	 * @param plat plato a crear
	 * @return Plato creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Plato create(@RequestBody Plato plat) throws PlatoDomainException {
		return platoService.create(plat);
	}

	/**
	 * Editar
	 * 
	 * @param plat Plato a editar
	 * @param id identificador del plato
	 * @return plato editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception Id no encontrado
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Plato update(@PathVariable Long id, @RequestBody Plato plat)
			throws PlatoDomainException, ResourceNotFoundException {
		return platoService.update(id, plat);
	}

	/**
	 * Eliminar
	 * 
	 * @param id id del plato
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		platoService.deleteById(id);
	}
}