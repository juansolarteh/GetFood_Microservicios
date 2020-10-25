package co.GetFood.Plato.domain.service;

import java.util.List;

import co.GetFood.commons.domain.Plato;
import co.GetFood.Plato.presentation.rest.exceptions.ProductDomainException;
import co.GetFood.Plato.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz de operaciones de la bd de productos
 * 
 * @author wpantoja, ahurtado
 *
 */

public interface IProductService {
	public List<Plato> findAll(int idRestaurante);

	public Plato create(Plato plato) throws ProductDomainException;

	public Plato update(int id, Plato plato) throws ProductDomainException;

	public void deleteById(int id) throws ResourceNotFoundException;

}
