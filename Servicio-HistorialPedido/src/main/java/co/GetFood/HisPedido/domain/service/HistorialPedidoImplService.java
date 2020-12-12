package co.GetFood.HisPedido.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.GetFood.HisPedido.access.dao.IPedidoDao;
import co.GetFood.HisPedido.domain.entity.Item;
import co.GetFood.HisPedido.domain.entity.Pedido;
import co.GetFood.HisPedido.presentation.rest.exceptions.EnumErrorCodes;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoError;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Implementación de la Interfaz IPedidoService
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

@Service
public class HistorialPedidoImplService implements IHistorialPedidoService{
	/**
	 * Inyección de pedido Dao y orderState
	 */
	@Autowired
	private IPedidoDao pedidoDao;
	
	/**
	 * Servicio para buscar un pedido por ID
	 * 
	 * @return Listado de pedidos
	 */
	public Pedido findById(Long idPedido) throws ResourceNotFoundException {
		Pedido pedido = pedidoDao.findById(idPedido).orElse(null);
		if (pedido == null) {
			throw new ResourceNotFoundException();

		}
		return pedido;
	}
	
	/**
	 * Servicio para buscar todos los pedidos
	 * 
	 * @return Listado de pedidos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Pedido> findAll() {
		return (List<Pedido>) pedidoDao.findAll();
	}

	/**
	 * Busca los pedidos de un restaurante.
	 * @param idRest. Identificador del restaurante.
	 * @return List<Pedido> Lista de pedidos de restaurante con id idRest.
	 */
	@Override
	public List<Pedido> findByIdRest(Long idRest) throws ResourceNotFoundException{
		List<Pedido> pedidos =  pedidoDao.findByIdRest(idRest);
		if (pedidos == null || pedidos.size() < 1) {
			throw new ResourceNotFoundException();
		}
		return pedidos;
	}

	/**
	 * Crea un nuevo pedido
	 * 
	 * @param pedido Pedido a crear en la bd
	 * @return Pedido creado
	 */
	@Override
	@Transactional
	public Pedido create(Pedido pedido) throws PedidoDomainException{
		List<PedidoError> errors = validateDomain(pedido);
		if (!errors.isEmpty()) 
			throw new PedidoDomainException(errors);
		return pedidoDao.save(pedido);
	}
	
	/**
	 * Aplica validaciones o reglas del dominio para un pedido. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param pedido pedido a validar
	 * @return lista de errores de validación
	 */

	private List<PedidoError> validateDomain(Pedido pedido) {
		List<PedidoError> errors = new ArrayList<>();

		if (pedido.getNombre_restaurante() == null || pedido.getNombre_restaurante().isBlank()) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "nameRestaurant", "El nombre del restaurante es obligatorio"));
		}
		
		if (pedido.getDireccion_pedido() == null || pedido.getDireccion_pedido().isBlank()) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "direccion", "La dirección del cliente es obligatorio"));
		}

		if (pedido.getId_restaurante() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idRestaurant",
					"El nit del restaurante es obligatorio y mayor a cero"));
		}
		
		if (pedido.getId_cliente() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idCliente",
					"El id del cliente es obligatorio y mayor a cero"));
		}	
		
		if (pedido.getValor_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "precio",
					"El precio es obligatorio y mayor a cero"));
		}
		
		if (pedido.getTelefono_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "telefono",
					"El telefono del cliente es obligatorio y mayor a cero"));
		}
		
		if(pedido.getItems().size() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "items",
					"Es obligatorio agregar un plato al pedido"));
		}else {
			errors.addAll(validateDomain(pedido.getItems()));
		}	
		return errors;
	}
	
	private List<PedidoError> validateDomain(List<Item> items) {
		List<PedidoError> errors = new ArrayList<>();
		for(Item item : items) {
			if (item.getNombre_product() == null || item.getNombre_product().isBlank()) {
				errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del plato es obligatorio"));
			}
			
			if (item.getId_producto() <= 0) {
				errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idPlato",
						"El id del plato es obligatorio y mayor a cero"));
			}
			
			if (item.getPrecio_item() <= 0) {
				errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "precioItem",
						"El precio del item es obligatorio y mayor a cero"));
			}
			
			if (item.getPrecio_producto() <= 0) {
				errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "precioProducto",
						"El precio del producto es obligatorio y mayor a cero"));
			}
			
			if (item.getCantidad_producto() <= 0) {
				errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "cantidadProducto",
						"la cantidad del producto es obligatorio y mayor a cero"));
			}
		}
		return errors;
	}

}
