package co.GetFood.Item.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.GetFood.Pedido.access.dao.IItemDao;
import co.GetFood.Pedido.access.dao.IPedidoDao;
import co.GetFood.Pedido.domain.entity.EntityPedido;
import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.domain.service.IPedidoService;
import co.GetFood.Pedido.presentation.rest.exceptions.EnumErrorCodes;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoError;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;


/**
 * Implementación de la Interfaz IPlatoService
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */

@Service
public class ItemImplService implements IItemService {
	/**
	 * Inyección de plato Dao
	 */
	@Autowired
	private IItemDao ItemDao;

	/**
	 * Servicio para buscar todos los platos
	 * 
	 * @return Listado de platos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Item> findAll() {
		return (List<Item>) ItemDao.findAll();
	}
	
	/**
	 * Busca los platos de un restaurante.
	 * @param idRest. Identificador del restaurante.
	 * @return List<Plato> Lista de platos de restaurante con id idRest.
	 */
	@Override
	public List<Item> findByIdPedido(Long idPedido) throws ResourceNotFoundException{
		return ItemDao.findByIdPedido(idPedido);
	}
	
	/**
	 * Crea un nuevo plato
	 * 
	 * @param plat plato a crear en la bd
	 * @return Plato creado
	 */
	@Override
	@Transactional
	public Item create(Item item) throws PedidoDomainException {
		List<PedidoError> errors = validateDomain(item);

		if (!errors.isEmpty()) {
			throw new PedidoDomainException(errors);
		}

		return ItemDao.save(item);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un plato. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param plato plato a validar
	 * @return lista de errores de validación
	 */

	private List<PedidoError> validateDomain(Item item) {
		List<PedidoError> errors = new ArrayList<>();

		if (item.getNombre_product() == null || item.getNombre_product().isBlank()) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del plato es obligatorio"));
		}

		if (item.getId_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idPedido",
					"El id del pedido es obligatorio y mayor a cero"));
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
		return errors;
	}
	

}
