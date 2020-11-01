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
 * Servicios web de productos
 * 
 * @author wpantoja, ahurtado
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
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Plato> findAll() {
		return (List<Plato>) platoService.findAll();
	}

	/**
	 * Listar un producto por id
	 * 
	 * @param id identificador
	 * @return Producto en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Plato findById(@PathVariable Long id) throws ResourceNotFoundException {

		Plato plat = platoService.findById(id);
		return plat;
	}
	
	
	@RequestMapping(value = "rest/{id_rest}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Plato> findByIdRest(@PathVariable Long id_rest)  {
		return  (List<Plato>) platoService.findByIdRest(id_rest);
	}


	/**
	 * Crear un producto
	 * 
	 * @param product producto
	 * @return producto creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Plato create(@RequestBody Plato plat) throws PlatoDomainException {
		return platoService.create(plat);
	}

	/**
	 * Editar
	 * 
	 * @param product Producto a editar
	 * @param id      identificador del producto
	 * @return producto editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Plato update(@RequestBody Plato plat, @PathVariable Long id)
			throws PlatoDomainException, ResourceNotFoundException {
		return platoService.update(id, plat);
	}

	/**
	 * Eliminar
	 * 
	 * @param id id del producto
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		platoService.deleteById(id);
	}
}