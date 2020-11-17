package co.GetFood.Pedido.domain.service;

import java.util.List;

import co.GetFood.Pedido.domain.entity.EntityPedido;
import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz de operaciones de la bd de platos
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

public interface IPedidoService {
	
	public List<EntityPedido> findAll();

	public List<Pedido> findByIdRest(Long idRest) throws ResourceNotFoundException;

	public EntityPedido create(EntityPedido pedido) throws PedidoDomainException;
}
