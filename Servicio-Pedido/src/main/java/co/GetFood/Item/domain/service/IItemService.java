package co.GetFood.Item.domain.service;

import java.util.List;

import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz de operaciones de la bd de platos
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

public interface IItemService {
	
	public List<Item> findAll();

	public List<Item> findByIdPedido(Long idPedido) throws ResourceNotFoundException;
	
	public Item create(Item item) throws PedidoDomainException;
}
