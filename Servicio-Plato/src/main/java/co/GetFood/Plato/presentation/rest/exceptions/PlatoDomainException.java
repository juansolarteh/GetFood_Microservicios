package co.GetFood.Plato.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un plato
 * 
 * * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public class PlatoDomainException extends Exception {
	/**
	 * Listado de errores
	 */
	public final List<PlatoError> errors;

	public PlatoDomainException(List<PlatoError> errors) {
		this.errors = errors;
	}
}
