package co.GetFood.Plato.domain.service;

import java.util.List;

import co.GetFood.Plato.presentation.rest.exceptions.PlatoDomainException;
import co.GetFood.Plato.presentation.rest.exceptions.ResourceNotFoundException;
import co.GetFood.Plato.domain.entity.Plato;

/**
 * Interfaz de operaciones de la bd de productos
 * 
 * @author wpantoja, ahurtado
 *
 */

public interface IPlatoService {
	public List<Plato> findAll();

	public Plato findById(Long id) throws ResourceNotFoundException;

	public Plato create(Plato plato) throws PlatoDomainException;

	public Plato update(Long id, Plato plato) throws PlatoDomainException, ResourceNotFoundException;

	public void deleteById(Long id) throws ResourceNotFoundException;

}
