package co.GetFood.Plato.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import co.GetFood.Plato.presentation.rest.exceptions.ProductDomainException;
import co.GetFood.Plato.presentation.rest.exceptions.ProductError;
import co.GetFood.Plato.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.commons.access.Factory;
import co.GetFood.commons.access.IRestauranteRepository;
import co.GetFood.commons.domain.Plato;

/**
 * Implementación de la Interfaz IProductService
 * 
 * @author wpantoja, ahurtado
 *
 */

@Service
public class ProductImplService implements IProductService {
	/**
	 * Inyección de producto Dao
	 */
	@Autowired
	private IRestauranteRepository productDao = Factory.getInstance().getRepository();

	/**
	 * Servicio para buscar todos los productos
	 * 
	 * @return Listado de productos
	 */
	@Override
	public List<Plato> findAll(int idRestaurante) {
		return (List<Plato>) productDao.getMenu(idRestaurante);
	}

	/**
	 * Crea un nuevo producto
	 * 
	 * @param product producto a crear en la bd
	 * @return Producto creado
	 */
	@Override
	public Plato create(Plato plato) throws ProductDomainException {
		List<ProductError> errors = validateDomain(plato);

		if (!errors.isEmpty()) {
			throw new ProductDomainException(errors);
		}

		return productDao.addPlato(plato);
	}

	/**
	 * Modifica o edita un producto
	 * 
	 * @param id,     identificador del producto a modificar
	 * @param product producto con los datos a editar
	 * @return Producto modificado
	 */
	@Override
	public Plato update(int id, Plato plato) throws ProductDomainException{
		List<ProductError> errors = validateDomain(plato);

		if (!errors.isEmpty()) {
			throw new ProductDomainException(errors);
		}
		
		//falta implementar la actualizacion en la BD

		return plato;
	}

	/**
	 * Aplica validaciones o reglas del dominio para un producto. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param product producto a validad
	 * @return lista de errores de validación
	 */

	private List<ProductError> validateDomain(Plato plato) {
		List<ProductError> errors = new ArrayList<>();

		if (plato.getAtrNombre() == null || plato.getAtrNombre().isBlank()) {
			errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "nombre", "El nombre del plato es obligatorio"));
		}
		
		if (plato.getAtrDescripcion() == null || plato.getAtrDescripcion().isBlank()) {
			errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "descripcion", "La descripcion del plato es obligatorio"));
		}

		if (plato.getAtrPrecio() <= 0) {
			errors.add(new ProductError(EnumErrorCodes.INVALID_NUMBER, "precio",
					"El precio del plato es obligatorio y mayor a cero"));
		}
		return errors;

	}

	/**
	 * Eliminar producto por su id
	 * 
	 * @param id identificador del producto a eliminar
	 */
	@Override
	public void deleteById(int id) throws ResourceNotFoundException {
		//Plato plato = this.findById(id);
		//if (plato == null) {
		//	throw new ResourceNotFoundException();
		//}
		//productDao.deleteById(id);
		//metodo findById no se ha implmentado en BD ni en su Interface
		//igualmente metodo delete
	}

}
