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
import co.GetFood.HisPedido.domain.service.IHistorialPedidoService;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("historial")
public class HistorialPedidoController {
	
	@Autowired
	private IHistorialPedidoService historialPedidoService;
	
	@RequestMapping(value = "rest/{id_rest}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findByIdRest(@PathVariable Long id_rest) throws ResourceNotFoundException  {
		return historialPedidoService.findByIdRest(id_rest);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Pedido create(@RequestBody Pedido pedido) throws PedidoDomainException {	
		return historialPedidoService.create(pedido);
	}
}
