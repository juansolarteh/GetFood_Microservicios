package co.GetFood.restaurante.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un producto
 * 
 * @author wpantoja, ahurtado
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
