package co.GetFood.HisPedido.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.GetFood.HisPedido.domain.entity.Pedido;
import co.GetFood.HisPedido.domain.service.IPedidoService;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Servicios web de Historial-pedido
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

public class PedidoController {
	
	
	private IPedidoService pedidoService;

	/**
	 * Listar todos
	 * 
	 * @return listado de pedidos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findAll() {
		return pedidoService.findAll();
	}
	
	/**
	 * listar pedidos por restaurante.
	 * @param id_rest identificador del restaurante.
	 * @return Lista de pedidos de restaurante con id id_rest.
	 * @throws ResourceNotFoundException 
	 * @throws PedidoDomainException 
	 */
	@RequestMapping(value = "rest/{id_rest}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findByIdRest(@PathVariable Long id_rest) throws ResourceNotFoundException  {
		return pedidoService.findByIdRest(id_rest);
	}
	
	/**
	 * Crear un pedido
	 * 
	 * @param pedido Pedido a crear
	 * @return Pedido creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Pedido create(@RequestBody Pedido pedido) throws PedidoDomainException {	
		return pedidoService.create(pedido);
	}
}
