package co.GetFood.restaurante.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un plato
 * 
 * * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public class RestauranteDomainException extends Exception {
	/**
	 * Listado de errores
	 */
	public final List<RestauranteError> errors;

	public RestauranteDomainException(List<RestauranteError> errors) {
		this.errors = errors;
	}
}
