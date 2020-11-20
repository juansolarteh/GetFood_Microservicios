package co.GetFood.restaurante.presentation.rest.exceptions;

import co.GetFood.restaurante.domain.service.EnumErrorCodes;

/**
 * Error de un restaurante
 * 
 * * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public class RestauranteError {
	/**
	 * Codigo del error
	 */
	public final EnumErrorCodes code;
	/**
	 * Campo del error
	 */
	public final String field;
	/**
	 * Descripción del error
	 */
	public final String description;

	public RestauranteError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
