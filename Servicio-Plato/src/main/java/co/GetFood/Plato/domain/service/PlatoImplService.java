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
 * Implementación de la Interfaz IPlatoService
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Tulande
 *
 */

@Service
public class PlatoImplService implements IPlatoService {
	/**
	 * Inyección de plato Dao
	 */
	@Autowired
	private IPlatoDao platoDao;

	/**
	 * Servicio para buscar todos los platos
	 * 
	 * @return Listado de platos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Plato> findAll() {
		return (List<Plato>) platoDao.findAll();
	}

	/**
	 * Busca un plato por su Id
	 * 
	 * @param id identificador del plato
	 * @return objeto de tipo plato
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
	 * Crea un nuevo plato
	 * 
	 * @param plat plato a crear en la bd
	 * @return Plato creado
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
	 * Modifica o edita un plato
	 * 
	 * @param id,     identificador del plato a modificar
	 * @param plato plato con los datos a editar
	 * @return Plato modificado.
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
	 * Aplica validaciones o reglas del dominio para un plato. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param plato plato a validar
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
		
		if (plato.getIdRest() <= 0) {
			errors.add(new PlatoError(EnumErrorCodes.INVALID_NUMBER, "id restaurante",
					"El id del restaurante es obligatorio y mayor a cero"));
		}
		
		if (plato.getDescription() == null || plato.getDescription().isBlank()) {
			errors.add(new PlatoError(EnumErrorCodes.EMPTY_FIELD, "description", "La descripcion del plato es obligatoria"));
		}
		return errors;

	}

	/**
	 * Eliminar plato por su id
	 * 
	 * @param id identificador del plato a eliminar
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
	
	/**
	 * Busca los platos de un restaurante.
	 * @param idRest. Identificador del restaurante.
	 * @return List<Plato> Lista de platos de restaurante con id idRest.
	 */
	@Override
	public List<Plato> findByIdRest(Long idRest){
		return (List<Plato>) platoDao.findByIdRest(idRest);
	}

}
