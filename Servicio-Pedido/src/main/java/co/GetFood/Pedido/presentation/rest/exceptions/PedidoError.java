package co.GetFood.Pedido.presentation.rest.exceptions;


/**
 * Error de un Pedido
 * 
 * * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
public class PedidoError {
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

	public PedidoError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
