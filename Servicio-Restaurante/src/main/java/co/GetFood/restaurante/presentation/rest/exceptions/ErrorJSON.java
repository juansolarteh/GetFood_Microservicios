package co.GetFood.restaurante.presentation.rest.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.GetFood.restaurante.domain.service.EnumErrorCodes;

/**
 * Maneja los errores en formato Json. Es utilizada por ErrorsPayload
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

	public final EnumErrorCodes code;
	public final String field;
	public final String message;

	public ErrorJSON(EnumErrorCodes code, String field, String message) {
		this.code = code;
		this.field = field;
		this.message = message;
	}
}
