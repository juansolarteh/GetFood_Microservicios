package co.GetFood.Pedido.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.GetFood.Pedido.access.dao.IPedidoDao;
import co.GetFood.Pedido.domain.entity.EntityPedido;
import co.GetFood.Pedido.domain.entity.Pedido;
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
public class PedidoImplService implements IPedidoService {
	/**
	 * Inyección de plato Dao
	 */
	@Autowired
	private IPedidoDao pedidoDao;
	
	/**
	 * Servicio para buscar todos los platos
	 * 
	 * @return Listado de platos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<EntityPedido> findAll() {
		return (List<EntityPedido>) pedidoDao.findAll();
	}
	
	/**
	 * Busca los pedidos de un restaurante.
	 * @param idRest. Identificador del restaurante.
	 * @return List<Plato> Lista de pedidos de restaurante con id idRest.
	 */
	@Override
	public List<Pedido> findByIdRest(Long idRest) throws ResourceNotFoundException{
		return (List<Pedido>) pedidoDao.findByIdRest(idRest);
	}

	/**
	 * Crea un nuevo pedido
	 * 
	 * @param plat plato a crear en la bd
	 * @return Plato creado
	 */
	@Override
	@Transactional
	public EntityPedido create(EntityPedido pedido) throws PedidoDomainException{
		List<PedidoError> errors = validateDomain(pedido);
		if (!errors.isEmpty()) {
			throw new PedidoDomainException(errors);
		}

		return pedidoDao.save(pedido);
	}
	
	
	
	/**
	 * Aplica validaciones o reglas del dominio para un plato. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param plato plato a validar
	 * @return lista de errores de validación
	 */

	private List<PedidoError> validateDomain(EntityPedido pedido) {
		List<PedidoError> errors = new ArrayList<>();

		if (pedido.getNombre_restaurante() == null || pedido.getNombre_restaurante().isBlank()) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "nameRestaurant", "El nombre del restaurante es obligatorio"));
		}
		
		if (pedido.getDireccion_pedido() == null || pedido.getDireccion_pedido().isBlank()) {
			errors.add(new PedidoError(EnumErrorCodes.EMPTY_FIELD, "direccion", "La dirección del cliente es obligatorio"));
		}

		if (pedido.getId_rest() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idRestaurant",
					"El nit del restaurante es obligatorio y mayor a cero"));
		}
		
		if (pedido.getId_cliente() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idCliente",
					"El id del cliente es obligatorio y mayor a cero"));
		}
		
		if (pedido.getId_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "idPedido",
					"El id del pedido es obligatorio y mayor a cero"));
		}
		
		if (pedido.getPrecio_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "precio",
					"El precio es obligatorio y mayor a cero"));
		}
		
		if (pedido.getTelefono_pedido() <= 0) {
			errors.add(new PedidoError(EnumErrorCodes.INVALID_NUMBER, "telefono",
					"El telefono del cliente es obligatorio y mayor a cero"));
		}

		return errors;
	}


}
