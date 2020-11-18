package co.GetFood.Pedido.domain.service;

import java.util.List;

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
	
	public List<Pedido> findAll();

	public List<Pedido> findByIdRest(Long idRest) throws ResourceNotFoundException;

	public Pedido create(Pedido pedido) throws PedidoDomainException;
}
