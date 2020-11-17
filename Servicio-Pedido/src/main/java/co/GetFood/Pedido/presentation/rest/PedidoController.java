package co.GetFood.Pedido.presentation.rest;

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

import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.domain.service.IPedidoService;
import co.GetFood.Pedido.domain.service.PedidoBuilder;
import co.GetFood.Pedido.domain.service.PedidoBuilderObtener;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;


/**
 * Servicios web de platos
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("Pedido")
public class PedidoController {

	@Autowired
	private PedidoBuilder pedidoBuilder;
	
	
	/**
	 * listar platos por restaurante.
	 * @param id_rest identificador del restaurante.
	 * @return Lista de platos de restaurante con id id_rest.
	 * @throws ResourceNotFoundException 
	 * @throws PedidoDomainException 
	 */
	@RequestMapping(value = "rest/{id_rest}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findByIdRest(@PathVariable Long id_rest) throws PedidoDomainException, ResourceNotFoundException  {
		pedidoBuilder = new PedidoBuilderObtener(new Pedido(id_rest));
		pedidoBuilder.generatePedido();
		pedidoBuilder.addItem();
		return pedidoBuilder;
	}


	/**
	 * Crear un plato
	 * 
	 * @param plat plato a crear
	 * @return Plato creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Plato create(@RequestBody Plato plat) throws PedidoDomainException {
		return platoService.create(plat);
	}
}