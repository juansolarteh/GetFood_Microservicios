package co.GetFood.Plato.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un producto
 * 
 * @author wpantoja, ahurtado
 *
 */
public class ProductDomainException extends Exception {
	/**
	 * Listado de errores
	 */
	public final List<ProductError> errors;

	public ProductDomainException(List<ProductError> errors) {
		this.errors = errors;
	}
}
