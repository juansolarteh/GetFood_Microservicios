package co.GetFood.Pedido.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un plato
 * 
 * * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public class PedidoDomainException extends Exception {
	/**
	 * Listado de errores
	 */
	public final List<PedidoError> errors;

	public PedidoDomainException(List<PedidoError> errors) {
		this.errors = errors;
	}
}
