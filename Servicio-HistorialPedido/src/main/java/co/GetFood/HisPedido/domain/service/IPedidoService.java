package co.GetFood.HisPedido.domain.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import co.GetFood.HisPedido.domain.entity.Pedido;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz de operaciones de la bd de pedidos
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

public interface IPedidoService {
	
	public List<Pedido> findAll();

	public List<Pedido> findByIdRest(Long idRest) throws ResourceNotFoundException;

	public Pedido create(Pedido pedido) throws PedidoDomainException;
	
}
