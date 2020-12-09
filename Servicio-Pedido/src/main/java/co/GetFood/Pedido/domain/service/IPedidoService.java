package co.GetFood.Pedido.domain.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;

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
	
	public Pedido SendOrder(Long idPedido, Pedido pedido) throws ResourceNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException ;

	public void deliverOrder(Long idPedido) throws ResourceNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, Exception;	
	
	public List<Pedido> findByState(String state) throws Exception;
}
