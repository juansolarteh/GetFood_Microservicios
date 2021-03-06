package co.GetFood.Pedido.presentation.rest;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;


import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.domain.service.IPedidoService;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;


/**
 * Servicios web de pedido
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("pedidos")
public class PedidoController {

	@Autowired
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
	
	@RequestMapping(value = "sent", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findAllStateSent() throws Exception {
		List<Pedido> lst = pedidoService.findByState("SendNotPayState");
		lst.addAll(pedidoService.findByState("SendState"));
		return lst;
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
	
	@RequestMapping(value = "send/{id_pedido}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Pedido updateSend(@PathVariable Long id_pedido) throws ResourceNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		return pedidoService.SendOrder(id_pedido);
	}
	
	@RequestMapping(value = "deliver/{id_pedido}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void updateDelivery(@PathVariable Long id_pedido) throws Exception {
		pedidoService.deliverOrder(id_pedido);
	}
}