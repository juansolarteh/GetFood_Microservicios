package co.GetFood.Plato.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.GetFood.Plato.presentation.rest.exceptions.PlatoDomainException;
import co.GetFood.Plato.presentation.rest.exceptions.PlatoError;
import co.GetFood.Plato.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.Plato.access.dao.IPlatoDao;
import co.GetFood.Plato.domain.entity.Plato;

/**
 * Implementación de la Interfaz IProductService
 * 
 * @author wpantoja, ahurtado
 *
 */

@Service
public class PlatoImplService implements IPlatoService {
	/**
	 * Inyección de producto Dao
	 */
	@Autowired
	private IPlatoDao platoDao;

	/**
	 * Servicio para buscar todos los productos
	 * 
	 * @return Listado de productos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Plato> findAll() {
		return (List<Plato>) platoDao.findAll();
	}

	/**
	 * Busca un producto por su Id
	 * 
	 * @param id identificador del producto
	 * @return objeto de tipo producto
	 */
	@Override // Para que esté sincronizada con la bd
	public Plato findById(Long id) throws ResourceNotFoundException {
		Plato plat = platoDao.findById(id).orElse(null);
		if (plat == null) {
			throw new ResourceNotFoundException();

		}
		return plat;

	}

	/**
	 * Crea un nuevo producto
	 * 
	 * @param product producto a crear en la bd
	 * @return Producto creado
	 */
	@Override
	@Transactional
	public Plato create(Plato plat) throws PlatoDomainException {
		List<PlatoError> errors = validateDomain(plat);

		if (!errors.isEmpty()) {
			throw new PlatoDomainException(errors);
		}

		return platoDao.save(plat);
	}

	/**
	 * Modifica o edita un producto
	 * 
	 * @param id,     identificador del producto a modificar
	 * @param product producto con los datos a editar
	 * @return Producto modificado
	 */
	@Override
	@Transactional
	public Plato update(Long id, Plato plato) throws PlatoDomainException, ResourceNotFoundException {
		Plato plat = this.findById(id);
		if (plat == null) {
			throw new ResourceNotFoundException();
		}

		List<PlatoError> errors = validateDomain(plato);

		if (!errors.isEmpty()) {
			throw new PlatoDomainException(errors);
		}

		plat.setName(plato.getName());
		plat.setPrice(plato.getPrice());
		plat.setDescription(plato.getDescription());
		plat.setPrice(plato.getPrice());

		return platoDao.save(plat);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un producto. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param product producto a validad
	 * @return lista de errores de validación
	 */

	private List<PlatoError> validateDomain(Plato plato) {
		List<PlatoError> errors = new ArrayList<>();

		if (plato.getName() == null || plato.getName().isBlank()) {
			errors.add(new PlatoError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del plato es obligatorio"));
		}

		if (plato.getPrice() <= 0) {
			errors.add(new PlatoError(EnumErrorCodes.INVALID_NUMBER, "price",
					"El precio del plato es obligatorio y mayor a cero"));
		}
		
		if (plato.getDescription() == null || plato.getDescription().isBlank()) {
			errors.add(new PlatoError(EnumErrorCodes.EMPTY_FIELD, "description", "La descripcion del plato es obligatoria"));
		}
		return errors;

	}

	/**
	 * Eliminar producto por su id
	 * 
	 * @param id identificador del producto a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long id) throws ResourceNotFoundException {
		Plato plat = this.findById(id);
		if (plat == null) {
			throw new ResourceNotFoundException();
		}
		platoDao.deleteById(id);
	}

	@Override
	public List<Plato> findByIdRest(Long idRest){
		return (List<Plato>) platoDao.findByIdRest(idRest);
	}

}
